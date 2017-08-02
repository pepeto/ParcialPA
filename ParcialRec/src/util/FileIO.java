package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import business.dto.Invoice;

public class FileIO {
    private  String root;

    public FileIO() {
    }

    public FileIO(String root) {
        this.root = root;
    }

    public boolean write(Object object) {
        File file = null;

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            file = new File(root);

            if (!file.exists()) {
                file.createNewFile();
            }

            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(object);
        } catch (Exception e) {
            return false;
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return true;
    }

    // Guarda cada registro en un archivo diferente pasado en filename - Si ya existe el archovo devuelve false
    public boolean writeRec(Object object, String filename) {
        File file = null;
        boolean retValue = true;

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            file = new File(filename);

            if (file.exists()) {
                retValue = false;
            }
            
            file.createNewFile();

            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(object);
        } catch (Exception e) {
            return false;
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return retValue;
    }

    
    public Object read() {
        File file = null;

        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        Object object = null;

        try {
            file = new File(root);

            if (!file.exists()) {
                file.createNewFile();
            }

            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);

            object = objectInputStream.readObject();
        } catch (Exception e) {
            return object;
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return object;
    }
    
    // Levanta el directorio con las facturas existentes y manda a cargar las facturas una por una en el list
    public Object loadList(String path){
    	File[] f = readDirectoryFileNames(path);
    	ArrayList<Object> array = new ArrayList<Object>();
    	
    	for(File i : f){
    		array.add(readRecordFile(path + i.getName()));
    	}
		return array;
    	
    }
    
    // Levanta cada archivo individual de facturas
    public Object readRecordFile(String path) {
        File file = null;

        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        Object object = null;

        try {
			fileInputStream = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			objectInputStream = new ObjectInputStream(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        try {
			object = objectInputStream.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        

        return object;
    }
    
    
    // Devuelve lista de archivos en un directorio pasado como parametro.
    public File[] readDirectoryFileNames(String path) {
    	    	
    	// Corta el path en la ultima barra /
    	path = IO.pathOnly(path);
    	
    	File dir = new File(path);
    	File[] listOfFiles = dir.listFiles();

    	for (File file : listOfFiles) {
    		if (file.isFile()) {
    			System.out.println(file.getName());
    		}
    	}
		return listOfFiles;
   
    }
    
    
}
