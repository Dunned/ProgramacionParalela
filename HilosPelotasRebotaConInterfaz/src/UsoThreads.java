import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;



public class UsoThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame marco=new MarcoRebote();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}



//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Pelota{
	
	// Mueve la pelota invirtiendo posici�n si choca con l�mites
	
	public void mueve_pelota(Rectangle2D limites){
		
		x+=dx;
		
		y+=dy;
		
		if(x<limites.getMinX()){
			
			x=limites.getMinX();
			
			dx=-dx;
		}
		
		if(x + TAMX>=limites.getMaxX()){
			
			x=limites.getMaxX() - TAMX;
			
			dx=-dx;
		}
		
		if(y<limites.getMinY()){
			
			y=limites.getMinY();
			
			dy=-dy;
		}
		
		if(y + TAMY>=limites.getMaxY()){
			
			y=limites.getMaxY()-TAMY;
			
			dy=-dy;
			
		}
		
	}
	
	//Forma de la pelota en su posici�n inicial
	
	public Ellipse2D getShape(){
		
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
		
	}	
	
	private static final int TAMX=15;
	
	private static final int TAMY=15;
	
	private double x=0;
	
	private double y=0;
	
	private double dx=1;
	
	private double dy=1;
	
	
}

// L�mina que dibuja las pelotas----------------------------------------------------------------------


class LaminaPelota extends JPanel{
	
	//A�adimos pelota a la l�mina
	
	public void add(Pelota b){
		
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		for(Pelota b: pelotas){
			
			g2.fill(b.getShape());
		}
		
	}
	
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}


//Marco con l�mina y botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame{
	
	public MarcoRebote(){
		
		setBounds(600,300,600,350);
		
		setTitle ("Rebotes");
		
		lamina=new LaminaPelota();
		
		add(lamina, BorderLayout.CENTER);
		
		JPanel laminaBotones=new JPanel();
                
                
                arranca1=new JButton("HILO1");
                arranca1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        comienza_el_juego(1);
                     
                    }
                });
                
                laminaBotones.add(arranca1);
                
                arranca2=new JButton("HILO2");
                arranca2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        comienza_el_juego(2);
                    }
                });
                
                laminaBotones.add(arranca2);
                
                
                arranca3=new JButton("HILO3");
                arranca3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        comienza_el_juego(3);
                       
                    }
                });
                
                laminaBotones.add(arranca3);
                
                
                
                detener1=new JButton("DETENER1");
                detener1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        detener(1);
                       
                    }
                }); 
                laminaBotones.add(detener1);
                
                
                detener2=new JButton("DETENER2");
                detener2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        detener(2);
                        
                    }
                });
                laminaBotones.add(detener2);
                
                
                detener3=new JButton("DETENER 3");
                detener3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        detener(3);
                        
                    }
                });
                laminaBotones.add(detener3);
		
		
		
		add(laminaBotones, BorderLayout.SOUTH);
	}
	

        
	//A�ade pelota y la bota 1000 veces
	
	public void comienza_el_juego (int n){
			
			Pelota pelota=new Pelota();
			
			lamina.add(pelota);
			
			Runnable r=new PelotaHilos(pelota, lamina);
                        if (n==1){
                            t1Thread=new Thread(r);
                            t1Thread.start();
                            
                        }
                        if (n==2){
                            t2Thread=new Thread(r);
                            t2Thread.start();
                            
                        }
                        if (n==3){
                            t3Thread=new Thread(r);
                            t3Thread.start();
                            
                        }
	}
        
        public void detener(int n){
            if (n==1){
                t1Thread.interrupt();

            }
            if (n==2){
                t2Thread.interrupt();

            }
            if (n==3){
                t3Thread.interrupt();;
            }
        }
	
        
        Thread t1Thread,t2Thread,t3Thread;
        JButton arranca1,arranca2,arranca3,
                detener1,detener2,detener3;
        
	private LaminaPelota lamina;
	
	
}
