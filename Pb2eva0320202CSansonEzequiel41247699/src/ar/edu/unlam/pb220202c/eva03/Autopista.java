package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;


public class Autopista{
	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los atributos o metodos que crean convenientes
	private HashMap <Integer,Vehiculo> telepase = new HashMap<Integer,Vehiculo>();
	private HashSet <Vehiculo> vehiculosEnCirculacion = new HashSet<Vehiculo>();
	private Integer cantidadDeVehiculosEnCirculacion=0;
	private TreeSet <Vehiculo> vehiculosEnExcesoDeVelocidad = new TreeSet<Vehiculo>();
	
	public Boolean registrarTelepase (Integer numeroTelepase, Vehiculo vehiculo) {
		if((!telepase.containsKey(numeroTelepase))&& (!telepase.containsValue(vehiculo))) {
			return true;
		}
		return false;
	}
	
	public Boolean ingresarAutopista (Integer numeroTelepase) throws VehiculoNotFoundException{
		
		Boolean ingreso = false;
		if(!telepase.containsKey(numeroTelepase)) {
			throw new VehiculoNotFoundException("Vehiculo no encontrado");
		}
		else{
			vehiculosEnCirculacion.add(telepase.get(numeroTelepase));
			ingreso = true;
			cantidadDeVehiculosEnCirculacion++;
		}
		
		return ingreso;
	}
	
	public Boolean salirAutpista (Vehiculo vehiculo) throws VehiculoNotFoundException{
		Boolean salio=false;
		if(!vehiculosEnCirculacion.contains(vehiculo)) {
			throw new VehiculoNotFoundException("No se encontro el vehiculo");
		}
		else {
			vehiculosEnCirculacion.remove(vehiculo);
			cantidadDeVehiculosEnCirculacion--;
			salio=true;
		}
	return salio;
	}
	
	public void vehiculosEnInfraccion() {
        for (Vehiculo vehiculo : vehiculosEnCirculacion) {
            if (vehiculo.enInfraccion())
                vehiculosEnExcesoDeVelocidad.add(vehiculo);
        }

    }
	
	
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){
		
        PorPatenteComparator ordenador = new PorPatenteComparator();
        TreeSet<Vehiculo> vehiculosPorPatente = new TreeSet<Vehiculo>(ordenador);
        vehiculosPorPatente.addAll(vehiculosEnExcesoDeVelocidad);
        return vehiculosPorPatente;
    }
	
	public Integer cantidadDeVehiculosENCirculacion() {
	
		return cantidadDeVehiculosEnCirculacion;
}

	
	}
