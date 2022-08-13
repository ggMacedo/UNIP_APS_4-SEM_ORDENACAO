package aps;

import javax.swing.JOptionPane;
import java.util.ArrayList;


public class APS {

	//Metodo Bubble Sort
		 public static void BubbleSort(int [] vetor){
		
			int n = vetor.length;
			int MenorNumero;
			
			 for(int i=0; i < n; i++){
				 for(int j=1; j < (n-i); j++){
			
					 if(vetor[j-1] > vetor[j]){
			
						 MenorNumero = vetor[j-1];
						 vetor[j-1] = vetor[j];
						 vetor[j] = MenorNumero;
					 }

				 }
			 }
		 }

	 //Metodo Selection Sort
	 public static int[] SelectionSort(int[] vetor){

		 for (int i = 0; i < vetor.length - 1; i++){
			 int aux = i;
			 for (int j = i + 1; j < vetor.length; j++)
				 if (vetor[j] < vetor[aux])
				 	aux = j;
		 			int MenorNumero = vetor[aux];
		 			vetor[aux] = vetor[i];
		 			vetor[i] = MenorNumero;
		 }
		 return vetor;

	 }

	 //Metodo Insertion Sort
	 public static void InsertionSort(int vetor[]){
        int n = vetor.length;
        for (int i = 1; i < n; ++i) {
            int chave = vetor[i];
            int j = i - 1;
 
            while (j >= 0 && vetor[j] > chave) {
            	vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = chave;
        }
	 }
	 
	 //Mostra vetores
	 public static void printVetor(int metodo, int opc, ArrayList vetorOri, int [] vetorOrdenado, long tempo) {
		 
		 if(metodo == 1) {
			 System.out.println("M�todo de Ordena��o Selecionado: Bubble Sort");
		 }else if(metodo == 2) {
			 System.out.println("M�todo de Ordena��o Selecionado: Selection Sort");
		 }else {
			 System.out.println("M�todo de Ordena��o Selecionado: Insertion Sort");
		 }
		 
		 if(opc == 1) {
			 System.out.println("Gera��o de N�meros: N�meros Pr�-Selecionados");
		 }else {
			 System.out.println("Gera��o de N�meros: N�meros Aleat�rios");
		 }
		 
		 System.out.println("Vetor[Indice] = Original || Ordenado");
		 System.out.println("------------------------------------");
		 
		 for (int i=0; i<vetorOri.size(); i++) {
			 System.out.printf("v[%d] = %8s, %8d\n",i, vetorOri.get(i).toString(),vetorOrdenado[i]);

		 }
	
		 System.out.println("\n");
		 System.out.println("Tempo de ordena��o: " + tempo +"ms");
	 }
	 
	 //Usuario gera valores
	 public static void userGeraValores(ArrayList vetororiginal) {
		 long tempo = 0;
		 int contador =0, i ,n;
		 String continuar="", opcao = "";
		 
		 while (!continuar.equals("n")) {
			 try {
				 int elemento = Integer.parseInt(JOptionPane.showInputDialog("Digite um n�mero:"));
				 vetororiginal.add(elemento);
				 contador++;
			 }catch(Exception e) {
				 JOptionPane.showMessageDialog(null, "Op��o inv�lida, digite novamente.\nErro: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
				 continuar = "0";
				 continue;
			 }
			 continuar = JOptionPane.showInputDialog("Deseja continuar? Pressione QUALQUER TECLA para SIM ou N para N�O."); 
		 }
		 
		 n = contador;
		 int vetorordenado[] = new int[n];
		 
		 for (i = 0;i<n;i++) {
		 	vetorordenado[i] = Integer.parseInt(vetororiginal.get(i).toString());
		 }
	
	
	 	do {
	 		opcao = JOptionPane.showInputDialog("Digite 1 para Bubble Sort\nDigite 2 para Selection Sort\nDigite 3 para Insertion Sort");
	
			 if (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3")) {
				 JOptionPane.showMessageDialog(null, "Op��o inv�lida!", "Erro", JOptionPane.ERROR_MESSAGE);
			 }
			 
	 	}while (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3"));
	 	

	 	if(opcao.equals("1")) {
	 		Cronometro.start();
	 		BubbleSort(vetorordenado);
	 		Cronometro.stop();
	 		tempo = Cronometro.elapsedTime();
	 		printVetor(1, 1, vetororiginal, vetorordenado, tempo);
	 		
		}else if (opcao.equals("2")) {
			 Cronometro.start();
			 SelectionSort(vetorordenado);
			 Cronometro.stop();
			 tempo = Cronometro.elapsedTime();
			 printVetor(2, 1, vetororiginal, vetorordenado, tempo);
			 
		}else if (opcao.equals("3")){
			 Cronometro.start();
			 InsertionSort(vetorordenado);
			 Cronometro.stop();
			 tempo = Cronometro.elapsedTime();
			 printVetor(3, 1, vetororiginal, vetorordenado, tempo);
		}

		 
	 }
	 
	 
	 //Valores gerados aleatoriamente
	 public static void aleatoriGeraValores(ArrayList vetororiginal) {
		 int x;
		 int vetorordenado[];
		 long tempo = 0;
		 int  i ,n;
		 String opcao = "";
		 
		 try {
			 
			 n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de n�meros aleat�rios desejada:"));
			 vetorordenado = new int[n];

			 for (i=0; i<n; i++) {	
				 x = (int)Math.round(Math.random()*n); 
				 vetororiginal.add(x); 
				 vetorordenado[i] = x;
			 }
			 
			 
			 
			 do {
				 
				 opcao = JOptionPane.showInputDialog("Digite 1 para Bubble Sort\nDigite 2 para Selection Sort\nDigite 3 para Insertion Sort");
		
				 if (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3")) {
					 JOptionPane.showMessageDialog(null, "Op��o inv�lida!", "Erro", JOptionPane.ERROR_MESSAGE);
				 }
				 
			 }while (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3"));
			 
		 
	
			 if (opcao.equals("1")) {
				
				 Cronometro.start();
				 BubbleSort(vetorordenado);
				 Cronometro.stop();
				 tempo = Cronometro.elapsedTime();
				 printVetor(1, 2, vetororiginal, vetorordenado, tempo);
				 
			 }else if (opcao.equals("2")) {
				
				 Cronometro.start();
				 SelectionSort(vetorordenado);
				 Cronometro.stop();
				 tempo = Cronometro.elapsedTime();
				 printVetor(2, 2, vetororiginal, vetorordenado, tempo);
				 
			}else if (opcao.equals("3")){
				
				 Cronometro.start();
				 InsertionSort(vetorordenado);
				 Cronometro.stop();
				 tempo = Cronometro.elapsedTime();
				 printVetor(3, 2, vetororiginal, vetorordenado, tempo);
				 
			}
			 
		 }catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Op��o inv�lida!\nErro: " + e, "Erro", JOptionPane.ERROR_MESSAGE); 
			main(null);
		 }
	 
	 }
	 
	 //Main
	 public static void main(String[] args) {
		 
		 String opcao="";
		 ArrayList vetororiginal = new ArrayList();

		 do {
			 
			 opcao =JOptionPane.showInputDialog("Digite 1 para pr�-selecionar os n�meros a serem ordenados\nDigite 2 para usar n�meros aleat�rios a serem ordenados");
		
			 if (!opcao.equals("1") && !opcao.equals("2")) {
				 JOptionPane.showMessageDialog(null, "Op��o inv�lida!", "Erro", JOptionPane.ERROR_MESSAGE);
			 }
			 
		 }while (!opcao.equals("1") && !opcao.equals("2"));
	
	
		 //Usuario seleciona numeros
		 if (opcao.equals("1")) {
			 userGeraValores(vetororiginal);
			 JOptionPane.showMessageDialog(null, "Valores ordenados com sucesso!\nVeja a listagem dos valores no console.", "Sucesso", JOptionPane.PLAIN_MESSAGE);
		 
		 }
		 
		 //Numeros Aleatorios 
		 else if(opcao.equals("2")){
			 aleatoriGeraValores(vetororiginal);
			 JOptionPane.showMessageDialog(null, "Valores ordenados com sucesso!\nVeja a listagem dos valores no console.", "Sucesso", JOptionPane.PLAIN_MESSAGE);
			 
		 }
	
	 }

 }