package prueba2;

public class threadJobs implements Runnable {

	@Override
	public void run() {
		float value = 0;
		for (int i = 0; i < 1000; i++) {
			value = value + 1000;
			value = value/1000;
		}
		System.out.println("Thread says tweeeeet!!!" + value);
	}

	private static final int NUMEROHILOS = 50;

	public static void main(String[] args) {
		// La entrada es el numero de threads que se van a ejecutar
		Thread[] lista = new Thread[NUMEROHILOS];
		for (int i = 0; i < NUMEROHILOS; i++) {
			lista[i] = (new Thread(new threadJobs()));
			lista[i].start();
		}
		try{
			// Esperamos por a los hilos
			for(int i = 0; i < lista.length; i++) {
				lista[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Han finalizado los hilos");


	}




}
