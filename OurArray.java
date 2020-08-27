public class OurArray<T> {
	//declare a reference to an array
	private T [] Ar;
	//int size
	private int size;
	//constructor that accepts a size 
	public OurArray(int s) {
		//create the array
		Ar = (T[]) new Object[s];
		size = 0;
	}
	//default constructor
	public OurArray(){
		this(100);//will call the constructor ourArray(int s)
	}
	//accessor for size 
	public int Getsize() {
		return size;
	}
	//is full return true if full false if not
	public boolean isFull() {
		if(size == Ar.length)
			return true;
		
		return false;
	}
	//isEmpty
	public boolean isEmpty(){
		if(size == 0)
			return true;
		return false;
	}
	//AddBack
	public void AddBack(T e) {
		if(this.isFull()) {
			System.out.println("The array is full");
			return;
		}
		Ar[size] = e;
		size++;
	}
	//AddFront: move all elements up by 1 starting at size-1
	//then insert element at index 0
	void addFront(T e) {
		if(this.isFull()) {
			System.out.println("The array is full");
			return;
		}
		//free inxdex 0 by pushing everything up by 1
		for (int i = size-1; i >= 0; i--) {
			Ar[i+1] = Ar[i];
		}
		Ar[0] = e;
		size++;
	}
	public String toString(){
		//We want to dusplay the array in the form
		//[-2, -3, -9, -13]
		if(this.isEmpty())
			return "[]";
		
		String st = "[";
		for(int i = 0; i < size -1; i++){
			st += Ar[i].toString() + ", ";
		}
		st += Ar[size-1].toString() + "]";
		return st;
	}
	public void addElement(T e, int ind){
		//check if the index is valid, if not return
		if(this.isFull())
		{
			System.out.println("The array is full");
			return;
		}
		if(ind<0 || ind>size)
		{
			System.out.println("Invalid index");
			return;
		}
		//push all elements up by one down to the index
		//insert element at index 
		for(int i = size-1; i >= ind; i--)
		{
			Ar[i+1]=Ar[i];
		}
		Ar[ind] = e;
		//don't forget to increase the size. 
		size++;
	}
	T elementAt(int ind){ 
		//returns the elements at the specific index
		if(ind < 0 || ind >= size){
			System.out.println("Invalid index");
			return null;
		}
		return Ar[ind];	
	}
	T removeFront() {
		return removeElement(0);
	}
	T removeElement(int ind) {
		//check if index is valid 
		if(ind<0||ind>=size){
			System.out.println("Element does not exist");
			return null;
		}
		//save element at ind
		T a = Ar[ind];
		//bring all elements down by one starting from ind
		for (int i=ind; i<size-1; i++)
		{
			Ar[i]=Ar[i+1];
		}
		//dcrease the size 
		--size;
		//return saved element
		return a;	
	}
	T removeBack(){
		return this.removeElement(size-1);
	}
}