package Agenda;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Agendafinal
{
	static PrintWriter salidadatos;
	static FileWriter  salidaregistro;
	static Scanner scn;
	static FileReader entradaregistro;
	
	static int contador =1;
	static int ultimoid=1;
	static String [] [] contacto = new String [contador] [6];
	
	public static void main(String[] args) 
	{
		String dirRegistro = "C:\\Users\\ivanna\\eclipse-workspace\\Introprogra\\src\\Agenda\\Agenda2.txt";
		
	
		
		AbrirRegistro(dirRegistro);
		abrirRegistro(dirRegistro);
		LeerRegistro();
		
    
	}

	public static void AbrirRegistro (String dirRegistro2)
	{
		try 
		{
			entradaregistro = new FileReader (dirRegistro2);
		}
		
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		scn = new Scanner (entradaregistro);
	}
	
    public static void  abrirRegistro (String dirRegistro2)
       
    {
        try 
		{
			salidaregistro = new FileWriter(dirRegistro2,true);
		}
        
        catch (IOException e)
	   	{
	   		 e.printStackTrace();
	   	}
		salidadatos= new PrintWriter (salidaregistro);
		
    }
        
    public static void escribirRegistro (String cadenaTexto)   
    {  
    		salidadatos.println (cadenaTexto); 
    }
    
    
 
	public static void LeerRegistro ()
	{
		String  opcion=""; 
		
		
        boolean salir =true;
	    
	    String e ="";
	//	
		
		do{
			//int j=0;
			while (scn.hasNextLine())
			{
				scn.nextLine();
				contador++;
			}
			
			opcion = JOptionPane.showInputDialog ("Inserte una opcion"+  "\n"+
					 "1. Agregar Contacto "+  "\n"+
					 "2. Buscar Contacto" +  "\n"+
					"3.Imprimir Contacto" +  "\n"+
					 "4. Eliminar Contacto" +  "\n"+
					"5. Actualizar Contacto"+  "\n"+
					  "6. Salir"+ "\n" + "Recuerde poner el número de la opción o la primer palabra de esta"); 
			
			switch (opcion)
			{
			case "1":
			case "Agregar":
				
				 
				  ultimoid++;
				 String [] [] temporal = new String [contador][6];
                 
                 for (int i=0; i<contador -1; i ++)
                 {
              	   for (int j=0;j<6;j++)
              	   {
              		   temporal [i][j] =contacto [i][j];
              	   }
                 }
						 
				String nombre = JOptionPane.showInputDialog ("Insertar nombre ");
				String apellido = JOptionPane.showInputDialog("Insertar apellido");
				String numerocasa = JOptionPane.showInputDialog("Insertar numero de casa");
				String numeronormal = JOptionPane.showInputDialog ("Insertar numero personal");
				
				String [] fecha = new String [3];
			    fecha [0] =  JOptionPane.showInputDialog  ( "Insertar dia de nacimiento"); 
			    fecha [1] = JOptionPane.showInputDialog(" Insertar mes de nacimiento");
			    fecha [2]= JOptionPane.showInputDialog(" Insertar año de nacimiento (solo los ultimos dos digitos)");
			  
			      String fechacom = fecha [0] + "-" +fecha [1] +  "-" +fecha [2];

                      
                       
			            String linea ="";
					   
					   temporal [contacto.length-1] [0] = nombre;
					   temporal [contacto.length-1] [1] = apellido; 
					   temporal [contacto.length-1] [2] = numerocasa; 
					   temporal [contacto.length-1] [3] = numeronormal;
					   temporal [contacto.length-1] [4] = fechacom;
					   temporal  [contacto.length-1][5]= String.valueOf(ultimoid)
;					   
					    contacto =temporal;
					  
					   linea=  temporal [contacto.length-1][5] + "," + nombre + ","+ apellido +  "," + numerocasa +  "," + numeronormal + ", " + fechacom;
					  contador ++;
					 
					 System.out.println(linea);
				   
					 
			    escribirRegistro (linea);
			   
			    
			    
				
	            break;
	           
			
			case "2": 
			case "Buscar":
		
				
				String pregunta = JOptionPane.showInputDialog("Inserte el id");
				String contact ="";
				String busqueda;
				
			
				
				while (pregunta != contact)
				{
					
					while (scn.hasNextLine())
					{
						busqueda = scn.nextLine();
						String [] xx = busqueda.split(",");
						contact = xx [0];
						if (pregunta.compareTo(contact)==0)
								{
							System.out.println (busqueda);
								}
						
					
					}
					
								
				}
				
				
			;break;
			
			case "3": 
			case "Imprimir":
				
				
				
			    String  impresion ="";
			    
			    
				while (scn.hasNextLine())
				{   
					impresion = scn.nextLine();
					System.out.println (impresion);
				}
				
				
				
			;break;
			
			case "4": 
			case "Borrar":
				
			
				
				
				
				String preguntaa = JOptionPane.showInputDialog("Inserte el id");
				String id= "";
			      
				
				int contadorr=0;
				String contactos [][]= new String[contadorr][6];
				
				while (preguntaa != id)
				{
					
					while (scn.hasNextLine())
					{
						busqueda = scn.nextLine();
						String [] xxx = busqueda.split(",");
						id = xxx [0];
						contador = Integer.parseInt(id);
						
						if (preguntaa.compareTo(id)==0)
						
						{
	
					for (int i = 0; i < contadorr; i++) {
			            if( contador == Integer.parseInt(contacto[i][0]))
			            {
			            	contadorr--;
			                for(int j = 0; j < i; j++) 
			                {
			                    for(int k = 0; k < 6; k++) 
			                    {
			                        contactos[j][k] = contacto[j][k];
			                    }
			                }
			                for(int j = i; j < contadorr; j++) {
			                    for(int k = 0; k < 6; k++) {
			                        contactos[j][k] = contacto[j + 1][k];
			                    }
			                }
			                for(int l = i; l < contadorr; l++){
			                	contactos[l][0] = String.valueOf(Integer.parseInt(contactos[l][0]) - 1);
			                }
			            }
					}
					contacto = contactos;
				
				 }
				}
				}
				
	/*}
	 * 
	 *
				
				String contac="";
				String busc ="";
				String normal = "";
			
				
			
			 pregunta = JOptionPane.showInputDialog("Digite el numero de identificación del usuario" );
			 
			    
				while (pregunta != contac)
				{
					
					while (scn.hasNextLine())
					{
						busc = scn.nextLine();
						String [] xxx = busc.split(",");
						contac = xxx [0];
						
						if (contac.compareTo(busc)==0)
							
						{   
								for (int k=1; k<contador; k++)
								{
									contacto [contacto.length][k]  =null;
									System.out.println ("Contacto eliminado");
								}
							
						}
					
						
				}
				
	*/
	
				break;
					
			case "5": 
			case "Actualizar":
				
				
			   
				;break;
				
			case "6":
			case "Salir":
			
				salir = false;
					break; 
			
			default: 
				JOptionPane.showMessageDialog (null,"No has seleccionado la opción correcta"); break;
				
	
		}
			
			
		} while (salir == true);
			
		cerrarRegistro();
		cerrarRegistrolectura();
	}

	
	

	public static void cerrarRegistro ()
	{
			scn.close();
		
	}
		
	public static void cerrarRegistrolectura()
	{
			
			salidadatos.close();
	}
}
