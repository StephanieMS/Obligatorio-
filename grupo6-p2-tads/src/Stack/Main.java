package Stack;

public class Main {

	public static void main(String[] args) {
		
		Stack s1 = new MyStack();
		
		s1.push(2);
		s1.push(3);
		s1.push(4);
		s1.push(5);
		
		s1.print();
		
		System.out.println(" ");
		
		try {
			s1.pop();
		}catch(EmptyStackException e1) {
			System.out.println(e1.getMessage());
		}
		
		try {
			System.out.println(s1.top());
		}catch(EmptyStackException e2) {
			System.out.println(e2.getMessage());
		}
		
		System.out.println(" ");
		
		s1.makeEmpty();
		
		s1.print();
		
		

	}

}
