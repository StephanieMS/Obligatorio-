package Queue;

@SuppressWarnings("serial")
public class EmptyQueueException extends Exception {

	public EmptyQueueException(String msj) {
		super(msj);
	}
}