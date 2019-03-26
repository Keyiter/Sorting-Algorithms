import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.text.Document;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.util.regex.Pattern;
import javax.swing.text.BadLocationException;
import javax.swing.JTextArea;



public class Displaying extends JPanel implements ActionListener{

	public static final int HEIGHT = 100;
	public static final int WIDTH = 300;
	private JButton Select;
	private JButton Heap;
	private JButton Shell;
	private JButton Quick;
	private JButton GetArray;
	public JTextField input;
	private JTextArea outputo;
	private JTextArea outputs;
	private JTextArea outputd;
	private JTextArea timepassed;
	private JCheckBox random;
	private JCheckBox asc;
	private JCheckBox rasc;
	private JCheckBox rdesc;
	private JCheckBox raf;
	private JCheckBox rvf;
	private JCheckBox dod;
	private JScrollPane scroll1;
	private JScrollPane scroll2;
	private JScrollPane scroll3;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	public Integer[] Array;

	
	public Displaying() {

		Select = new JButton("Select");
		Heap = new JButton("Heap");
		Shell = new JButton("Shell");
		Quick = new JButton("Quick");
		GetArray = new JButton("Wczytaj");
		input = new JTextField(10);
		outputo = new JTextArea(1,10);
		outputs = new JTextArea(1,10);
		outputd = new JTextArea(1,10);
		timepassed = new JTextArea();
		random = new JCheckBox("Losowe");
		asc = new JCheckBox("Sort rosn¹co");
		dod = new JCheckBox("Dane Dodatkowe");
		rasc = new JCheckBox("rosn¹ce");
		rdesc = new JCheckBox("malej¹ce");
		raf = new JCheckBox("A kszta³tne");
		rvf = new JCheckBox("V kszta³tne");
		scroll1 = new JScrollPane(outputd);
		scroll2 = new JScrollPane(outputo);
		scroll3 = new JScrollPane(outputs);
		label1 = new JLabel("Czas wykonania                                                ");
		label2 = new JLabel("Pivot/Pryrost                                                                               ");
		label3 = new JLabel("Ci¹g oryginalny");
		label4 = new JLabel("Ci¹g posortowany");
		asc.setSelected(false);
		random.setSelected(false);
		outputo.setEditable(false);
		outputs.setEditable(false);
		outputd.setEditable(false);
		timepassed.setEditable(false);
		timepassed.setLineWrap(true);
		input.setPreferredSize( new Dimension( 200, 24 ) );
		scroll1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll1.setPreferredSize(new Dimension(450, 40) );
		scroll2.setPreferredSize(new Dimension(560, 40) );
		scroll3.setPreferredSize(new Dimension(560, 40) );
		outputo.setBounds(0,0, 1000, 50);
		scroll1.setBounds(10,60,600,30);
		scroll2.setBounds(10,60,600,30);
		scroll3.setBounds(10,60,600,30);
		input.setColumns(10);
		Select.addActionListener(this);
		Heap.addActionListener(this);
		Shell.addActionListener(this);
		Quick.addActionListener(this);
		GetArray.addActionListener(this);

			
			
		
		
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		add(Select);
		add(Heap);
		add(Shell);
		add(Quick);
		add(random);
		add(asc);
		add(dod);
		add(input);
		add(GetArray);
		add(rasc);
		add(rdesc);
		add(raf);
		add(rvf);		
		add(label1);
		add(label2);
		add(timepassed);
		add(scroll1);
		add(label3);
		add(scroll2);
		add(label4);
		add(scroll3);


	}
	
	public void GetArrayInit(){
		if(!random.isSelected()){
			 Array = GetIntArray();
		}
		else {
			 Array = RandNoumb();
		}
	}
	
	
	public Integer[] GetIntArray() {
		String tekst = input.getText();
		tekst = tekst.replaceAll("[^0-9]+", " ");
		tekst = tekst.replaceAll("\\s+", ", ");

		int l=0,k=0;
		while(l<tekst.length()){
			if (tekst.charAt(l)==' ') k++;
			l++;	
		}
		if (k >10) {
			Integer[] x={0,0,0,0,0,0,0,0,0,0};
			JOptionPane.showMessageDialog(null, " Mo¿na podaæ max 10 liczb" );
			   
			return x;
		}
		else{
		outputo.setText(tekst);
		String[] Noumbers = tekst.split(", ");
		Integer[] List = new Integer[Noumbers.length];
		
		for(int i=0;i<Noumbers.length;i++){
			List[i] = Integer.parseInt(Noumbers[i]);
		}	
		
			
		return List;}	
		
	}
	
	public void GetStringFromInt(Integer[] List){
		String Disp="";
		
		for(int i=0;i<List.length;i++){
			Disp=Disp + List[i] +", ";			
		}
		
		
		outputs.setText(Disp);
	}
	
	public Integer[] RandNoumb(){
		String text = input.getText();
		text = text.replaceAll("[^0-9]+", "");
		text = text.replaceAll("\\s+", "");
		int n = Integer.parseInt(text);
		Integer[] List = new Integer[n];;
		Random generator = new Random();
		if(rasc.isSelected())
			List[0]=0;
		else if(rdesc.isSelected())
			List[0]= n/2;
		else if(raf.isSelected())
			List[0]= 0;
		else if(rvf.isSelected())
			List[0]= (n/4);
		else List[0] = generator.nextInt(1000);
		
		for (int i=1;i<n;i++){
			if(rasc.isSelected())
				List[i]=List[i-1] + generator.nextInt(6) - 2;
			else if(rdesc.isSelected())
				List[i]=List[i-1] - generator.nextInt(6) + 2;
			else if(raf.isSelected())
				if(i<n/2) List[i]=List[i-1] + generator.nextInt(6) - 2;
				else List[i]=List[i-1] -  generator.nextInt(6) + 2;
			else if(rvf.isSelected())
				if(i<n/2) List[i]=List[i-1] - generator.nextInt(6) + 2;
				else List[i]=List[i-1] +  generator.nextInt(6) - 2;
			else List[i] = generator.nextInt(1000);
			if(List[i]<0)i--;
		}
		text ="";
		if(dod.isSelected()){
		for(int i=0;i<List.length;i++){
			text=text + List[i] +", ";			
		}
		outputo.setText(text);
		}
		return List;
	}
	
	public void SelectionSort(){

	
		long tStart = System.currentTimeMillis();
		
		//sortowanie przez wybór

		for(int i=0; i< Array.length; i++){
			int min= i;
			for(int j = i; j<Array.length;j++){
				if(asc.isSelected()){
					if (Array[min]>Array[j]) min=j;
				}
				else if (Array[min]<Array[j]) min=j;
			}
			swap(Array,i,min);
			
		}
		
	
		
		
		long tEnd = System.currentTimeMillis();
		long tDelta = tEnd - tStart;
		double elapsedSeconds = tDelta / 1000.0;
		timepassed.setText(Double.toString(elapsedSeconds));
		if(dod.isSelected())
			GetStringFromInt(Array);
		
	}
	
	
	
	public Integer[] MakeShell(int n){
		Integer i=1;
		Double x = 0.0;
		while(x<(n/3)){
			 x = (Math.pow(3,i)-1)/2;

			i++;
			
		}
		Integer[] prz = new Integer[i];
		for (int j = 0; j<i-2;j++){
			 x = (Math.pow(3,j+1)-1)/2;
			prz[j]=x.intValue();
			
		}
		
		
		return prz;
	}
	
	
	

	public void ShellSort(){
	
		long tStart = System.currentTimeMillis();

		
		// Sortowanie z uzyciem malej¹cych przyrostów
		Integer[] przyrost;
		przyrost = MakeShell(Array.length);

		for(int h=przyrost.length-3;h>=0;h--){
			if(dod.isSelected())
				outputd.setText(outputd.getText() + przyrost[h]+", ");
			for(int i=0; i< przyrost[h]; i++)
				for (int j = i; j< Array.length;j=j+przyrost[h])
					for (int k =j;k>0;k=k-przyrost[h])
						if(k-przyrost[h]>=0) 
							if(asc.isSelected()){
								if(Array[k]<Array[k-przyrost[h]])
									swap(Array,k,k-przyrost[h]);
								}
							else if(Array[k]>Array[k-przyrost[h]])
								swap(Array,k,k-przyrost[h]);
							
			
			
		}
		long tEnd = System.currentTimeMillis();
		long tDelta = tEnd - tStart;
		double elapsedSeconds = tDelta / 1000.0;
		timepassed.setText(Double.toString(elapsedSeconds));
		if(dod.isSelected())
			GetStringFromInt(Array);
		
	}
	
	public void swap(Integer[] Array,int i,int j){
		int temp=Array[i];
		Array[i]=Array[j];
		Array[j]=temp;
		
	}
	
	public void BuildHeap(Integer Array[],int i,int n){
		int k = i;
		int j;
		do {
			j = k;
			if(asc.isSelected()){
				if (2*j <=n && Array[2*j]>Array[k])
					k=2*j;
				if ((2*j)+1<=n && Array[2*j+1]>Array[k])
					k=(2*j)+1;
			}else{
				if (2*j <=n && Array[2*j]<Array[k])
					k=2*j;
				if ((2*j)+1<=n && Array[2*j+1]<Array[k])
					k=(2*j)+1;
				
				
			}
				
			swap(Array,j,k);	
		}while(j!=k);
		

	}
	
	public void InitBuildHeap(Integer[] Array){
		for(int i = (Array.length)/2; i>=0;i--){
			BuildHeap(Array,i,Array.length-1);
			
		}
		
	}
	
	public void HeapSort(){
		
		long tStart = System.currentTimeMillis();
		
		InitBuildHeap(Array);
		for (int i = Array.length-1;i>0;i--){
			swap(Array,0,i);
			BuildHeap(Array,0,i-1);
		}

		long tEnd = System.currentTimeMillis();
		long tDelta = tEnd - tStart;
		double elapsedSeconds = tDelta / 1000.0;
		timepassed.setText(Double.toString(elapsedSeconds));
		if(dod.isSelected())
			GetStringFromInt(Array);
		
		
	}
	
	public void QuickSort(Integer[] Array,int i, int j){
		if(i<j){
		int akt=i, pivot = Array[(i+j)/2];
		swap(Array,(i+j)/2,j);
		if(dod.isSelected())
			outputd.setText(outputd.getText() + pivot+", ");
		for(int lewy=i;lewy<j;lewy++){
			if(asc.isSelected()){			
				if(Array[lewy]<pivot) {
					swap(Array,lewy,akt);
					akt++;
				}
			}else 
				if(Array[lewy]>pivot) {
					swap(Array,lewy,akt);
					akt++;
				}
		}
		swap(Array,akt,j);	
		
		QuickSort(Array,i,akt-1);
		QuickSort(Array,akt+1,j);
	
		}
	}
	
	
	public void QuickSortInit(){
		
		long tStart = System.currentTimeMillis();
		
		QuickSort(Array,0,Array.length-1);
		
		
		
		long tEnd = System.currentTimeMillis();
		long tDelta = tEnd - tStart;
		double elapsedSeconds = tDelta / 1000.0;
		timepassed.setText(Double.toString(elapsedSeconds));
		if(dod.isSelected())
			GetStringFromInt(Array);
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		outputd.setText("");
		outputs.setText("");

		
		if(source == Select)
			SelectionSort();
			

		else if(source == Heap)
			HeapSort();
		
		else if(source == Shell)
			ShellSort();
		
		else if(source == Quick)
			QuickSortInit();
		
		else if(source == GetArray)
			GetArrayInit();
		
		
		
	}



}