package prueba3;


public class informationThread implements Runnable{

	public static class Counter{
		private int c;
		public synchronized int incr() {
			return ++c;
		}
	}

	private Counter counter;

	public informationThread(Counter c){
		counter = c;
	}

	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			System.out.println("Thread "
					+ Thread.currentThread().getId()
					+ " says tweeeeet #"
					+ counter.incr() + " !!!");
		}
	}

	private static final int NUMEROHILOS = 2;

	public static void main(String[] args) {
		Counter contador = new Counter();
		// La entrada es el numero de threads que se van a ejecutar
		Thread[] lista = new Thread[NUMEROHILOS];
		for (int i = 0; i < NUMEROHILOS; i++) {
			lista[i] = (new Thread(new informationThread(contador)));
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
