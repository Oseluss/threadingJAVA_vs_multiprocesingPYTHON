package prueba1;

public class threadCreator implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread says tweeeeet!!!");
	}

	private static final int NUMEROHILOS = 50;

	public static void main(String[] args) {
		// La entrada es el numero de threads que se van a ejecutar
		Thread[] lista = new Thread[NUMEROHILOS];
		for (int i = 0; i < NUMEROHILOS; i++) {
			lista[i] = (new Thread(new threadCreator()));
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
