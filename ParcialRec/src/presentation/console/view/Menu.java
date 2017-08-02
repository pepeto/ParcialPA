package presentation.console.view;

import util.IO;

public class Menu {


    public static int show() {
        int option = 0;

        while (true) {
        	IO.print("Seleccione una Opcióon");
            IO.print("1. Factura");
            IO.print("2. Producto");
            IO.print("3. Terminar");

            option = IO.getInt();

            switch(option){
            	case 1: InvoiceMenu.show();
            			break;
            	case 2: ProductMenu.show();
            			break;
            	case 3: System.exit(1);
            			break;
            	default: IO.print("Opción inválida - reintente <1-3>");
            	
            	}
        }
        	
    }
    
}
