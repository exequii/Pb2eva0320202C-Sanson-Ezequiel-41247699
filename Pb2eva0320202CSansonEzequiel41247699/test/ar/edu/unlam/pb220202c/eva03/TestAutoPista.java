package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class TestAutoPista {
	
	@Test
	public void queSePuedaRegistrarTelepase () {
		Autopista paz = new Autopista();
		Vehiculo auto1 = new Automovil("AAA111",100,130);
		Vehiculo camion1 = new Camion("ZZZ111",60,80,4);
		
		assertTrue(paz.registrarTelepase(001, auto1));
		assertTrue(paz.registrarTelepase(002, camion1));
	}
	
	@Test
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion(){
		
		Autopista paz = new Autopista();
		Vehiculo auto1 = new Automovil("AAA222",100,130);
		
		try {
			paz.salirAutpista(auto1);
		} catch (VehiculoNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente() throws VehiculoNotFoundException{
		Autopista oeste = new Autopista();
        Vehiculo autoPrimero = new Automovil("AAA111", 140, 130);
        Camion camion1 = new Camion("CCC555", 70, 80,2);
        Camion camionUltimo = new Camion("ZZZ999", 90, 80,2);
        
        autoPrimero.enInfraccion();
        camion1.enInfraccion();
        camionUltimo.enInfraccion();
        
        
        oeste.registrarTelepase(100, autoPrimero);
        oeste.registrarTelepase(110, camion1);
        oeste.registrarTelepase(120, camionUltimo);
        
        oeste.ingresarAutopista(100);
        oeste.ingresarAutopista(110);
        oeste.ingresarAutopista(120);
        
        oeste.vehiculosEnInfraccion();
        assertEquals(autoPrimero, oeste.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().first());
        assertEquals(camionUltimo, oeste.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().last());
    }
	
	@Test
	public void queSePuedaIngresarDeLaAutopista() throws VehiculoNotFoundException {
		
		Autopista oeste = new Autopista();
        Vehiculo auto1 = new Automovil("AAA111", 100, 130);
        Camion camion1 = new Camion("CCC555", 70, 80,2);
        Camion camion2 = new Camion("ZZZ99", 70, 80,2);
        
        auto1.enInfraccion();
        camion1.enInfraccion();
        camion2.enInfraccion();
        
        
        oeste.registrarTelepase(100, auto1);
        oeste.registrarTelepase(110, camion1);
        oeste.registrarTelepase(120, camion2);
        
        
        assertTrue(oeste.ingresarAutopista(100));
		
        
        assertTrue(oeste.salirAutpista(auto1));

	}
	
	@Test
	public void queSePuedaSalirDeLaAutopista() throws VehiculoNotFoundException {
		
		Autopista oeste = new Autopista();
        Vehiculo auto1 = new Automovil("AAA111", 100, 130);
        Camion camion1 = new Camion("CCC555", 70, 80,2);
        Camion camion2 = new Camion("ZZZ99", 70, 80,2);
        
        auto1.enInfraccion();
        camion1.enInfraccion();
        camion2.enInfraccion();
        
        
        oeste.registrarTelepase(100, auto1);
        oeste.registrarTelepase(110, camion1);
        oeste.registrarTelepase(120, camion2);
        
        
        oeste.ingresarAutopista(100);
		
        
        assertTrue(oeste.salirAutpista(auto1));

	}
	
}
