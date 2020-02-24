import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.Timer;



public class Controller {
	View view;
	ArrayList<Buton> buttons = new ArrayList<Buton>();
	private int currVal = 1;
	
	public Controller() {
		view = new View();		
		createButtons();
		addListener();
	}
	
	public void setValues(int nrOfValues,int value) {
	int ok = 0;
		
		while(ok < nrOfValues) {
			Random rn = new Random();
			int l = rn.nextInt(5 - 1 + 1) + 1;
			int c =  rn.nextInt(5 - 1 + 1) + 1;
			
			for(Buton b : buttons) {
				if(b.l ==l && b.c == c && b.type == 0) {
					b.type = value;					
					b.button.setFont(new Font("Tahoma", Font.BOLD, 33));
					//b.button.setText(Integer.toString(value));					
					ok++;			
					
			}			
		}
		}
		
	}	
	public void valoarePreaMare(Buton buton) { //cartea dispare si doar clipeste ce se afla pe pozitia unde am dat click
		view.battleDetails.setText("Din pacate ai incercat sa salvezi un rang mai mare. Ai murit ! :))");			
		Timer timer = new Timer( 1000, new ActionListener(){			  
			  public void actionPerformed( ActionEvent e ){				  
				  view.battleDetails.setText("");
			  }
			} );
			timer.setRepeats( false );
			timer.start();		
			buton.button.setText(Integer.toString(buton.type));	
			
		timer = new Timer( 1000, new ActionListener(){			  
			  public void actionPerformed( ActionEvent e ){
				  buton.button.setText("");				  					
			  }
			} );
			timer.setRepeats( false );
			timer.start();		
			currVal++;
		
		
	}
	
	public void valoareMaiMica(Buton buton) {	//cartea nu dispare si se releva ce se afla pe pozitia unde am dat click
		view.battleDetails.setText("Felicitari, ai reusit sa salvezi un rang mai mic. Incearca in continuare !");
		Timer timer = new Timer( 1000, new ActionListener(){			  
			  public void actionPerformed( ActionEvent e ){				  
				  view.battleDetails.setText("");
			  }
			} );
			timer.setRepeats( false );
			timer.start();	
			buton.button.setText(Integer.toString(buton.type));
			view.textField.setText(Integer.toString(buton.type*10 + Integer.parseInt(view.textField.getText())));
			
	}
	
	public void valoareEgala(Buton buton) {	//cartea dispare si se releva ce se afla pe pozitia unde am dat click
		view.battleDetails.setText("Felicitari, ai reusit sa salvezi un rang egal cu tine. Ati plecat acasa impreuna .");
		buton.button.setText(Integer.toString(buton.type));
		currVal++;
		view.textField.setText(Integer.toString(buton.type*10 + Integer.parseInt(view.textField.getText())));
		
	}
	
	private void gasitInamic(Buton buton) {
		view.battleDetails.setText("Ai gasit unul din cei 3 inamici, dar ai si fost omorat. RIP");
		buton.button.setText(Integer.toString(buton.type));
		currVal++;
		
	}
	
	private void vazutRegele(Buton buton) {
		view.battleDetails.setText("Ai gasit regele inamic, dar ai si fost omorat. RIP");
		currVal++;
	}
	public void createButtons() {				
		
		buttons.add(new Buton((view.a1),1,1));
		buttons.add(new Buton((view.a2),2,1));
		buttons.add(new Buton((view.a3),3,1));
		buttons.add(new Buton((view.a4),4,1));
		buttons.add(new Buton((view.a5),5,1));
		
		buttons.add(new Buton((view.b1),1,2));
		buttons.add(new Buton((view.b2),2,2));
		buttons.add(new Buton((view.b3),3,2));
		buttons.add(new Buton((view.b4),4,2));
		buttons.add(new Buton((view.b5),5,2));
		
		buttons.add(new Buton((view.c1),1,3));
		buttons.add(new Buton((view.c2),2,3));
		buttons.add(new Buton((view.c3),3,3));
		buttons.add(new Buton((view.c4),4,3));
		buttons.add(new Buton((view.c5),5,3));
		
		buttons.add(new Buton((view.d1),1,4));
		buttons.add(new Buton((view.d2),2,4));
		buttons.add(new Buton((view.d3),3,4));
		buttons.add(new Buton((view.d4),4,4));
		buttons.add(new Buton((view.d5),5,4));
		
		buttons.add(new Buton((view.e1),1,5));
		buttons.add(new Buton((view.e2),2,5));
		buttons.add(new Buton((view.e3),3,5));
		buttons.add(new Buton((view.e4),4,5));
		buttons.add(new Buton((view.e5),5,5));
		
		//aici atribuim fiecarui buton nu anumit numar, conform jocului. Totul va fi random, de fiecare daca cand ne jucam, vom avea alta configuratie a jocului !
		//3 de 5
		//4 de 2
		//7 de 1
		//5 de 3
		//5 de 4 
		//regele 1		
		setValues(3,5);
		setValues(4,2);
		setValues(7,1);
		setValues(5,3);
		setValues(5,4);
						
		

}
	public Buton gasesteButon(int c, int l) {
		for(Buton buton : buttons) {
			if(buton.l == l && buton.c == c)
				return buton;
		}
		return null;
	}
	public boolean verifica5(Buton buton) {
		if(buton.type == 5)
			return true;
		return false;
	}
	public void verificareButon(Buton buton) throws InterruptedException {
		int l = buton.l;
		int c = buton.c;
		if(buton.type == 5)
			gasitInamic(buton);
		else
			if(buton.type == 0)
				vazutRegele(buton);
		if(currVal >= 1 && currVal <= 5) {
			if(1  < buton.type)
				valoarePreaMare(buton);
			else
				if(1 == buton.type)
					valoareEgala(buton);
				else
					valoareMaiMica(buton);
		}
		else {
			if(currVal >=6 && currVal <=7 )
				if( 2 <buton.type)
					valoarePreaMare(buton);
				else
					if(2 == buton.type)
						valoareEgala(buton);
					else
						valoareMaiMica(buton);
			else {
				if(currVal >= 8 && currVal <= 9 )
					if(3 < buton.type)
						valoarePreaMare(buton);
					else
						if(3 == buton.type)
							valoareEgala(buton);
						else
							valoareMaiMica(buton);
				else {
					if(currVal == 10)
						if(4 < buton.type)
							valoarePreaMare(buton);
						else
							if(4 == buton.type)
								valoareEgala(buton);
							else
								valoareMaiMica(buton);
					else {
						if(currVal == 11)
							if(5 < buton.type)
								valoarePreaMare(buton);
							else
								if(5 == buton.type)
									valoareEgala(buton);
								else
									valoareMaiMica(buton);
						
					}
						
				}
					
			}
		}
		
				//daca ne aflam in coltul din stanga sus
		if(c == 1 && l == 1) {			
			Buton butonVerif = gasesteButon(c+1,l);
			if(verifica5(butonVerif)) {
				coloreazaPericol2(buton);
				coloreazaBackGround2(buton);
			}
			butonVerif = gasesteButon(c,l+1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol2(buton);
				coloreazaBackGround2(buton);
			}
			butonVerif = gasesteButon(c+1,l+1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol2(buton);
				coloreazaBackGround2(buton);
			}								
		}
				//daca ne aflam in coltul din dreapta sus
		if(c == 5 && l == 1) {			
			Buton butonVerif = gasesteButon(c-1,l);
			if(verifica5(butonVerif)) {
				coloreazaPericol3(buton);
				coloreazaBackGround3(buton);
			}
			butonVerif = gasesteButon(c,l+1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol3(buton);
				coloreazaBackGround3(buton);
			}
			butonVerif = gasesteButon(c-1,l+1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol3(buton);
				coloreazaBackGround3(buton);
			}							
		}
				//daca ne aflam in coltul din stanga jos
		if(c == 1 && l == 5) {			
			Buton butonVerif = gasesteButon(c+1,l);
			if(verifica5(butonVerif)) {
				coloreazaPericol4(buton);
				coloreazaBackGround4(buton);
			}
			butonVerif = gasesteButon(c,l-1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol4(buton);
				coloreazaBackGround4(buton);
			}
			butonVerif = gasesteButon(c+1,l-1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol4(buton);
				coloreazaBackGround4(buton);
			}							
		}
				//daca ne aflam in coltul din dreapta jos
		if(c == 5 && l == 5) {			
			Buton butonVerif = gasesteButon(c-1,l);
			if(verifica5(butonVerif)) {
				coloreazaPericol5(buton);
				coloreazaBackGround5(buton);
			}
			butonVerif = gasesteButon(c-1,l-1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol5(buton);
				coloreazaBackGround5(buton);
			}
			butonVerif = gasesteButon(c,l-1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol5(buton);
				coloreazaBackGround5(buton);
			}								
		}
				//daca ne aflam pe coloana 1 intre linia 2 - 4
		if (c == 1 && l>=2 && l<=4) {
			Buton butonVerif = gasesteButon(c+1,l);
			if(verifica5(butonVerif)) {
				coloreazaPericol6(buton);
				coloreazaBackGround6(buton);
			}
			butonVerif = gasesteButon(c,l+1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol6(buton);
				coloreazaBackGround6(buton);
			}
			butonVerif = gasesteButon(c+1,l+1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol6(buton);
				coloreazaBackGround6(buton);
			}
			butonVerif = gasesteButon(c,l-1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol6(buton);
				coloreazaBackGround6(buton);
			}
			butonVerif = gasesteButon(c+1,l-1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol6(buton);
				coloreazaBackGround6(buton);
			}				
			
		}
			//daca ne aflam pe linia 1 coloana intre 2 - 4
		if(l == 1 && c >= 2 && c <= 4) {
			Buton butonVerif = gasesteButon(c+1,l);
			if(verifica5(butonVerif)) {
				coloreazaPericol7(buton);
				coloreazaBackGround7(buton);
			}
			butonVerif = gasesteButon(c,l+1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol7(buton);
				coloreazaBackGround7(buton);
			}
			butonVerif = gasesteButon(c+1,l+1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol7(buton);
				coloreazaBackGround7(buton);
			}
			butonVerif = gasesteButon(c-1,l);
			if(verifica5(butonVerif))
			{
				coloreazaPericol7(buton);
				coloreazaBackGround7(buton);
			}
			butonVerif = gasesteButon(c-1,l+1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol7(buton);
				coloreazaBackGround7(buton);
			}
			
		}
		
				//daca ne aflam pe coloana 5 intre linia 2-4
		if(c == 5 && l>=2 && l<=4) {
			Buton butonVerif = gasesteButon(c-1,l);
			if(verifica5(butonVerif)) {
				coloreazaPericol8(buton);
				coloreazaBackGround8(buton);
			}
			butonVerif = gasesteButon(c,l+1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol8(buton);
				coloreazaBackGround8(buton);
			}
			butonVerif = gasesteButon(c-1,l+1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol8(buton);
				coloreazaBackGround8(buton);
			}
			butonVerif = gasesteButon(c-1,l-1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol8(buton);
				coloreazaBackGround8(buton);
			}
			butonVerif = gasesteButon(c,l-1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol8(buton);
				coloreazaBackGround8(buton);
			}
			
		}
		
				//daca ne aflam pe linia 5 coloana 2 - 4
		if(l == 5 && c>=2 && c<=4) {
			System.out.print("Intru aici !");
			Buton butonVerif = gasesteButon(c-1,l);
			if(verifica5(butonVerif)) {
				coloreazaPericol9(buton);
				coloreazaBackGround9(buton);
			}
			butonVerif = gasesteButon(c,l-1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol9(buton);
				coloreazaBackGround9(buton);
			}
			butonVerif = gasesteButon(c-1,l-1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol9(buton);
				coloreazaBackGround9(buton);
			}
			butonVerif = gasesteButon(c+1,l);
			if(verifica5(butonVerif))
			{
				coloreazaPericol9(buton);
				coloreazaBackGround9(buton);
			}
			butonVerif = gasesteButon(c+1,l-1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol9(buton);
				coloreazaBackGround9(buton);
			}
			
		}
		
		
		
		
		if(c>=2 && c<=4 && l >=2 && l <= 4) {
			Buton butonVerif = gasesteButon(c+1,l);
			if(verifica5(butonVerif)) {
				coloreazaPericol1(buton);	
				coloreazaBackGround1(buton);
				
				
			}
				//System.out.print("In zona butonului "+buton.l + " "+buton.c + "este un 5 !");			
			butonVerif = gasesteButon(c,l+1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol1(buton);	
				coloreazaBackGround1(buton);
				
				
			}
			//System.out.print("In zona butonului "+buton.l + " "+buton.c + "este un 5 !");
			butonVerif = gasesteButon(c+1,l+1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol1(buton);	
				coloreazaBackGround1(buton);
			
			}
			//	System.out.print("In zona butonului "+buton.l + " "+buton.c + "este un 5 !");	
			butonVerif = gasesteButon(c-1,l);
			if(verifica5(butonVerif))
			{
				coloreazaPericol1(buton);
				coloreazaBackGround1(buton);
				
			}
			//	System.out.print("In zona butonului "+buton.l + " "+buton.c + "este un 5 !");			
			butonVerif = gasesteButon(c,l-1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol1(buton);	
				coloreazaBackGround1(buton);
				
			}
				//System.out.print("In zona butonului "+buton.l + " "+buton.c + "este un 5 !");
			butonVerif = gasesteButon(c-1,l-1);
			if(verifica5(butonVerif))
			{
				coloreazaPericol1(buton);
				coloreazaBackGround1(buton);			
				
			}
				//System.out.print("In zona butonului "+buton.l + " "+buton.c + "este un 5 !");		
		}
		
		
		
	}	


	

	private void coloreazaBackGround1(Buton buton) {
		Timer timer = new Timer( 1000, new ActionListener(){			  
			  public void actionPerformed( ActionEvent e ){
				  ArrayList<Buton> butToColor = new ArrayList<Buton>();
					butToColor.add(gasesteButon(buton.c + 1 ,buton.l));
					butToColor.add(gasesteButon(buton.c - 1 ,buton.l));
					butToColor.add(gasesteButon(buton.c + 1 ,buton.l+1));
					butToColor.add(gasesteButon(buton.c + 1 ,buton.l-1));
					butToColor.add(gasesteButon(buton.c ,buton.l+1));
					butToColor.add(gasesteButon(buton.c ,buton.l-1));
					butToColor.add(gasesteButon(buton.c - 1 ,buton.l+1));
					butToColor.add(gasesteButon(buton.c - 1 ,buton.l-1));
					for(Buton buton2: butToColor)
					buton2.button.setBackground(Color.LIGHT_GRAY);
					
			  }
			} );
			timer.setRepeats( false );
			timer.start();		
	}
	
	private void coloreazaBackGround6(Buton buton) {
		// TODO Auto-generated method stub
		Timer timer = new Timer( 1000, new ActionListener(){			  
			  public void actionPerformed( ActionEvent e ){
				  ArrayList<Buton> butToColor = new ArrayList<Buton>();
					butToColor.add(gasesteButon(buton.c + 1 ,buton.l));		
					butToColor.add(gasesteButon(buton.c + 1 ,buton.l+1));
					butToColor.add(gasesteButon(buton.c + 1 ,buton.l-1));
					butToColor.add(gasesteButon(buton.c ,buton.l+1));
					butToColor.add(gasesteButon(buton.c ,buton.l-1));
					
					for(Buton buton2: butToColor)
					buton2.button.setBackground(Color.LIGHT_GRAY);
					
			  }
			} );
			timer.setRepeats( false );
			timer.start();		
	}
	
	private void coloreazaBackGround7(Buton buton) {
		// TODO Auto-generated method stub
		Timer timer = new Timer( 1000, new ActionListener(){			  
			  public void actionPerformed( ActionEvent e ){
				  ArrayList<Buton> butToColor = new ArrayList<Buton>();
				  	butToColor.add(gasesteButon(buton.c + 1 ,buton.l));		
					butToColor.add(gasesteButon(buton.c + 1 ,buton.l+1));
					butToColor.add(gasesteButon(buton.c - 1 ,buton.l+1));
					butToColor.add(gasesteButon(buton.c ,  buton.l+1));
					butToColor.add(gasesteButon(buton.c-1 ,buton.l));					
					for(Buton buton2: butToColor)
						buton2.button.setBackground(Color.LIGHT_GRAY);
					
			  }
			} );
			timer.setRepeats( false );
			timer.start();		
	}
	
	private void coloreazaBackGround8(Buton buton) {
		// TODO Auto-generated method stub
		Timer timer = new Timer( 1000, new ActionListener(){			  
			  public void actionPerformed( ActionEvent e ){
				  ArrayList<Buton> butToColor = new ArrayList<Buton>();
				  butToColor.add(gasesteButon(buton.c - 1 ,buton.l));		
					butToColor.add(gasesteButon(buton.c - 1 ,buton.l+1));
					butToColor.add(gasesteButon(buton.c - 1 ,buton.l-1));
					butToColor.add(gasesteButon(buton.c ,  buton.l+1));
					butToColor.add(gasesteButon(buton.c ,buton.l-1));						
					for(Buton buton2: butToColor)
						buton2.button.setBackground(Color.LIGHT_GRAY);
					
			  }
			} );
			timer.setRepeats( false );
			timer.start();		
	}
	
	private void coloreazaBackGround9(Buton buton) {
		// TODO Auto-generated method stub
		Timer timer = new Timer( 1000, new ActionListener(){			  
			  public void actionPerformed( ActionEvent e ){
				  ArrayList<Buton> butToColor = new ArrayList<Buton>();
				  butToColor.add(gasesteButon(buton.c - 1 ,buton.l));		
					butToColor.add(gasesteButon(buton.c - 1 ,buton.l-1));
					butToColor.add(gasesteButon(buton.c  ,buton.l-1));
					butToColor.add(gasesteButon(buton.c+1 ,  buton.l-1));
					butToColor.add(gasesteButon(buton.c+1 ,buton.l));
					for(Buton buton2: butToColor)
						buton2.button.setBackground(Color.LIGHT_GRAY);
					
			  }
			} );
			timer.setRepeats( false );
			timer.start();		
	}
	private void coloreazaBackGround2(Buton buton) {
		// TODO Auto-generated method stub
		Timer timer = new Timer( 1000, new ActionListener(){			  
			  public void actionPerformed( ActionEvent e ){
				  ArrayList<Buton> butToColor = new ArrayList<Buton>();
				  butToColor.add(gasesteButon(buton.c + 1 ,buton.l));		
					butToColor.add(gasesteButon(buton.c + 1 ,buton.l+1));		
					butToColor.add(gasesteButon(buton.c ,buton.l+1));
					for(Buton buton2: butToColor)
						buton2.button.setBackground(Color.LIGHT_GRAY);
					
			  }
			} );
			timer.setRepeats( false );
			timer.start();		
	}
	
	private void coloreazaBackGround3(Buton buton) {
		// TODO Auto-generated method stub
		Timer timer = new Timer( 1000, new ActionListener(){			  
			  public void actionPerformed( ActionEvent e ){
				  ArrayList<Buton> butToColor = new ArrayList<Buton>();
				  butToColor.add(gasesteButon(buton.c - 1 ,buton.l));		
					butToColor.add(gasesteButon(buton.c - 1 ,buton.l+1));		
					butToColor.add(gasesteButon(buton.c ,buton.l+1));	
					for(Buton buton2: butToColor)
						buton2.button.setBackground(Color.LIGHT_GRAY);
					
			  }
			} );
			timer.setRepeats( false );
			timer.start();		
	}
	
	private void coloreazaBackGround4(Buton buton) {
		// TODO Auto-generated method stub
		Timer timer = new Timer( 1000, new ActionListener(){			  
			  public void actionPerformed( ActionEvent e ){
				  ArrayList<Buton> butToColor = new ArrayList<Buton>();
				  butToColor.add(gasesteButon(buton.c + 1 ,buton.l));		
					butToColor.add(gasesteButon(buton.c + 1 ,buton.l-1));		
					butToColor.add(gasesteButon(buton.c ,buton.l-1));		
					for(Buton buton2: butToColor)
						buton2.button.setBackground(Color.LIGHT_GRAY);
					
			  }
			} );
			timer.setRepeats( false );
			timer.start();		
	}
	
	private void coloreazaBackGround5(Buton buton) {
		// TODO Auto-generated method stub
		Timer timer = new Timer( 1000, new ActionListener(){			  
			  public void actionPerformed( ActionEvent e ){
				  ArrayList<Buton> butToColor = new ArrayList<Buton>();
				  butToColor.add(gasesteButon(buton.c - 1 ,buton.l));		
					butToColor.add(gasesteButon(buton.c - 1 ,buton.l-1));		
					butToColor.add(gasesteButon(buton.c ,buton.l-1));		
					for(Buton buton2: butToColor)
						buton2.button.setBackground(Color.LIGHT_GRAY);
					
			  }
			} );
			timer.setRepeats( false );
			timer.start();		
	}
	
	
		
		

	public void coloreazaPericol1(Buton buton) {
		//gasim toti vecinii butonului, si ii coloram
		ArrayList<Buton> butToColor = new ArrayList<Buton>();
		butToColor.add(gasesteButon(buton.c + 1 ,buton.l));
		butToColor.add(gasesteButon(buton.c - 1 ,buton.l));
		butToColor.add(gasesteButon(buton.c + 1 ,buton.l+1));
		butToColor.add(gasesteButon(buton.c + 1 ,buton.l-1));
		butToColor.add(gasesteButon(buton.c ,buton.l+1));
		butToColor.add(gasesteButon(buton.c ,buton.l-1));
		butToColor.add(gasesteButon(buton.c - 1 ,buton.l+1));
		butToColor.add(gasesteButon(buton.c - 1 ,buton.l-1));
		for(Buton buton2: butToColor)
		buton2.button.setBackground(new Color(0,0,0));
		
	}
	private void coloreazaPericol6(Buton buton) {
		// TODO Auto-generated method stub
		ArrayList<Buton> butToColor = new ArrayList<Buton>();
		butToColor.add(gasesteButon(buton.c + 1 ,buton.l));		
		butToColor.add(gasesteButon(buton.c + 1 ,buton.l+1));
		butToColor.add(gasesteButon(buton.c + 1 ,buton.l-1));
		butToColor.add(gasesteButon(buton.c ,buton.l+1));
		butToColor.add(gasesteButon(buton.c ,buton.l-1));
		
		for(Buton buton2: butToColor)
		buton2.button.setBackground(new Color(0,0,0));
		
	}
	
	private void coloreazaPericol7(Buton buton) {
		// TODO Auto-generated method stub
		ArrayList<Buton> butToColor = new ArrayList<Buton>();
			butToColor.add(gasesteButon(buton.c + 1 ,buton.l));		
			butToColor.add(gasesteButon(buton.c + 1 ,buton.l+1));
			butToColor.add(gasesteButon(buton.c - 1 ,buton.l+1));
			butToColor.add(gasesteButon(buton.c ,  buton.l+1));
			butToColor.add(gasesteButon(buton.c-1 ,buton.l));		
		for(Buton buton2: butToColor)
		buton2.button.setBackground(new Color(0,0,0));
		
	}
	

	private void coloreazaPericol8(Buton buton) {
		// TODO Auto-generated method stub
		ArrayList<Buton> butToColor = new ArrayList<Buton>();
		butToColor.add(gasesteButon(buton.c - 1 ,buton.l));		
		butToColor.add(gasesteButon(buton.c - 1 ,buton.l+1));
		butToColor.add(gasesteButon(buton.c - 1 ,buton.l-1));
		butToColor.add(gasesteButon(buton.c ,  buton.l+1));
		butToColor.add(gasesteButon(buton.c ,buton.l-1));		
		for(Buton buton2: butToColor)
		buton2.button.setBackground(new Color(0,0,0));
		
	}
	

	private void coloreazaPericol9(Buton buton) {
		// TODO Auto-generated method stub
		ArrayList<Buton> butToColor = new ArrayList<Buton>();
		butToColor.add(gasesteButon(buton.c - 1 ,buton.l));		
		butToColor.add(gasesteButon(buton.c - 1 ,buton.l-1));
		butToColor.add(gasesteButon(buton.c  ,buton.l-1));
		butToColor.add(gasesteButon(buton.c+1 ,  buton.l-1));
		butToColor.add(gasesteButon(buton.c+1 ,buton.l));		
		for(Buton buton2: butToColor)
		buton2.button.setBackground(new Color(0,0,0));
	}
	
	public void coloreazaPericol2(Buton buton) {
		ArrayList<Buton> butToColor = new ArrayList<Buton>();
		butToColor.add(gasesteButon(buton.c + 1 ,buton.l));		
		butToColor.add(gasesteButon(buton.c + 1 ,buton.l+1));		
		butToColor.add(gasesteButon(buton.c ,buton.l+1));	
		for(Buton buton2: butToColor)
		buton2.button.setBackground(new Color(0,0,0));
		
	}
	
	private void coloreazaPericol3(Buton buton) {
		// TODO Auto-generated method stub
		ArrayList<Buton> butToColor = new ArrayList<Buton>();
		butToColor.add(gasesteButon(buton.c - 1 ,buton.l));		
		butToColor.add(gasesteButon(buton.c - 1 ,buton.l+1));		
		butToColor.add(gasesteButon(buton.c ,buton.l+1));	
		for(Buton buton2: butToColor)
		buton2.button.setBackground(new Color(0,0,0));
	}
	
	private void coloreazaPericol4(Buton buton) {
		// TODO Auto-generated method stub
		ArrayList<Buton> butToColor = new ArrayList<Buton>();
		butToColor.add(gasesteButon(buton.c + 1 ,buton.l));		
		butToColor.add(gasesteButon(buton.c + 1 ,buton.l-1));		
		butToColor.add(gasesteButon(buton.c ,buton.l-1));	
		for(Buton buton2: butToColor)
		buton2.button.setBackground(new Color(0,0,0));		
	}
	

	private void coloreazaPericol5(Buton buton) {
		// TODO Auto-generated method stub
		ArrayList<Buton> butToColor = new ArrayList<Buton>();
		butToColor.add(gasesteButon(buton.c - 1 ,buton.l));		
		butToColor.add(gasesteButon(buton.c - 1 ,buton.l-1));		
		butToColor.add(gasesteButon(buton.c ,buton.l-1));	
		for(Buton buton2: butToColor)
		buton2.button.setBackground(new Color(0,0,0));	
		
	}
	public void addListener() {
		for(Buton buton : buttons) {
			buton.button.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					//view.battleDetails.setText("Am apasat butonul de pe linia  " + buton.l +" coloana "+ buton.c+ " cu valoarea "+buton.type);
					try {
						verificareButon(buton);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
		}
	}
	
	
}
