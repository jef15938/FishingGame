import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.applet.Applet;
import java.applet.AudioClip;


public class Fishing_Game  implements ActionListener{

	static AudioClip sound ;
	
	public static void main(String[] args) 
	{
		
		Start s=new Start();	
		new Fishing_Game().init();
		
		sound = null;
		try {
			sound=new Applet().newAudioClip(new URL("File:\\users\\fomsing-pc\\workspace\\Fishing\\bin\\遊戲bgm.au"));
			sound.play();
			sound.loop();	        
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	public void init()
	{
		JFrame JF=new JFrame("Music");
		JButton Play=new JButton("Play");
		JButton Stop=new JButton("Stop");
		try {
			Play.setIcon(new ImageIcon(ImageIO.read(new File("C:\\users\\fomsing-pc\\workspace\\Fishing\\bin\\播放.jpg"))));
			Stop.setIcon(new ImageIcon(ImageIO.read(new File("C:\\users\\fomsing-pc\\workspace\\Fishing\\bin\\停止.jpg"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Play.addActionListener(this);
		Stop.addActionListener(this);
		JF.setLayout(new GridLayout(1,2));
		JF.add(Play);
		JF.add(Stop);
		JF.setPreferredSize(new Dimension(400,250));
		JF.pack();
		JF.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Play"))
		{sound.play();}
		if(e.getActionCommand().equals("Stop"))
		{sound.stop();}
		
	}


}



class Start implements ActionListener
{
	static JFrame StartJF;
	static JButton Start_Btn;
	static JPanel JPU;
	static JPanel JPD;
	static JLabel JLU;
	static JButton JBD;

	static JLabel StartJL;
	
		Start()
		{
			StartJF=new JFrame("釣魚");
			StartJF.setLayout(new GridLayout(1,1));
			Start_Btn=new JButton("釣魚");
			JPU=new JPanel();
			JPD=new JPanel();
			JLU=new JLabel("釣魚趣");
			JLU.setFont(new Font("王漢宗粗鋼體一標準",0,100));
			JLU.setForeground(Color.decode("#550088"));
			
			JBD=new JButton("遊戲開始");
			JBD.setFont(new Font("王漢宗粗鋼體一標準",0,45));
			JBD.setForeground(Color.decode("#00FFFF"));
			
			JBD.setBackground(Color.BLUE);
			JBD.setOpaque(false);
			JBD.setBorder(null);
			
			JBD.addActionListener(this);
	
			
//	
//			try 	{
//				StartJF.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\fomsing-pc\\Desktop\\釣魚主題圖.jpg")))));
//			} 	catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			}
			
			
			
			//StartJL=new JLabel();
	
			try {
				StartJL=new JLabel(new ImageIcon(ImageIO.read(new File("C:\\users\\fomsing-pc\\workspace\\Fishing\\bin\\釣魚主題圖.jpg"))));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			StartJL.setLayout(new GridLayout(2,1));
			
			JPU.setLayout(new FlowLayout(0,100,80));
			JPU.add(JLU);
			JPU.setOpaque(false);
			
			
			JPD.setLayout(new FlowLayout(0,620,210));
			JPD.add(JBD);
			JPD.setOpaque(false);
		
			StartJL.add(JPU);
			StartJL.add(JPD);
		
			
			StartJF.add(StartJL);
			
			
			StartJF.setPreferredSize(new Dimension(1030,750));
			StartJF.pack();
			StartJF.setVisible(true);
			StartJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			LoadGame LD=new LoadGame();
			
		}
}

class LoadGame implements ActionListener
{
	Player[] players;
	JFrame Read_NumJF;  
	JFrame Read_NameJF;
	JLabel Set_players_num;
	JLabel Set_players_Name;
	TextField[] Read_players_Name;
	TextField Read_players_num;
	TextField Board_H;
	TextField Board_W;
	JButton Enter_Num;
	JButton Enter_Name;
	TextArea[] Name;
	int player_num;
	int Height;
	int Weight;
	
	
	LoadGame()
	{
		Read_NumJF=new JFrame("遊戲設定");    
		Read_players_num=new TextField("玩家人數");
		//Read_players_num.setPreferredSize(new Dimension(100,300));
		Enter_Num=new JButton("確定玩家人數");
		Enter_Num.addActionListener(this);
		
		Read_NumJF.setLayout(new GridLayout(1,2));
		Read_NumJF.add(Read_players_num);
		Read_NumJF.add(Enter_Num);
		Read_NumJF.setPreferredSize(new Dimension(400,200));
		Read_NumJF.pack();
		Read_NumJF.setVisible(true);
		Read_NumJF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("確定玩家人數")&&(int)Integer.parseInt(Read_players_num.getText())!=0)
		{
			player_num=Integer.parseInt(Read_players_num.getText());
			System.out.println("read num");
			Read_NumJF.dispose();
			
			Read_NameJF=new JFrame("遊戲設定");
			Enter_Name=new JButton("確定玩家姓名及棋盤大小");
			Enter_Name.addActionListener(this);
			
			Read_NameJF.setLayout(new GridLayout(player_num+4,1));
			Read_NameJF.setPreferredSize(new Dimension(300,300+player_num*100));
			
			Read_players_Name=new TextField[player_num];
			
			for(int i=0;i<player_num;i++)
			{
				Read_players_Name[i]=new TextField("玩家"+(i+1));
				Read_NameJF.add(Read_players_Name[i]);				
			}
			
			Board_W=new TextField("棋盤寬度");
			Board_H=new TextField("棋盤高度");
			JLabel Warning=new JLabel("棋盤長*寬要為偶數!");
			
			Read_NameJF.add(Board_W);
			Read_NameJF.add(Board_H);
			Read_NameJF.add(Warning);			
			Read_NameJF.add(Enter_Name);
			
			
			Read_NameJF.pack();
			Read_NameJF.setVisible(true);
			Read_NameJF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			

			
			
			
			
		}
		
		if(e.getActionCommand().equals("確定玩家姓名及棋盤大小")&&((int)Integer.parseInt(Board_W.getText())*(int)Integer.parseInt(Board_H.getText())%2==0))
		{
			int Weight=(int)Integer.parseInt(Board_W.getText());
			int Height=(int)Integer.parseInt(Board_H.getText());
			Board b=new Board(Height,Weight);

			players=new Player[player_num];
			
			for(int i=0;i<player_num;i++)
			{
				players[i]=new Player(Read_players_Name[i].getText());
			}
			b.AddPlayers(players);
			Read_NameJF.dispose();
			Read_NameJF.dispose();
		}
		
		
	}
}



class Board implements ActionListener
{
	int Round=0;
	int Player_Number;
	Player[] players;
	JFrame JF;
	JFrame ShowJF;
	JButton[] ShowJB;
	JLabel[] ShowJL_C;
	JLabel[] ShowJL_Message;
	JLabel JL;
	JPanel JP;
	Card[][] cards;
	Color[] colors_sample={Color.BLACK,Color.RED,Color.YELLOW,Color.GREEN,Color.BLUE,Color.PINK,Color.decode("#A500CC")};
	Color[] Random_Color;
	int[] ArrayInt;
	int Height,Weight;
	Vector<Color>Random_Color_Vector;
	Vector<Color>Random_Color_Separate;
	Random random=new Random();
	static int Step=1;
	Card Step1_Card;
	Card Step2_Card;
	Timer timer;
	int Cando=1;

	Board(int w,int h)
	{
		JF=new JFrame("釣魚");
		JF.setLayout(new BorderLayout());
		
		
		this.Weight=w;
		this.Height=h;
		Random_Color=new Color[w*h];
		ArrayInt=new int[w*h];
		for(int i=0;i<w*h;i++)
		{ArrayInt[i]=1;}
		
		Random_Color_Vector=new Vector();
		Random_Color_Separate=new Vector();
		
		JL=new JLabel();
		JL.setLayout(new GridLayout(h,w));
		
		Generate_Card();
		JF.add(JL);
		
		int size_n=0;
		
		if(w>h){size_n=900/w;}
		else{size_n=900/h;}
		

		JF.setPreferredSize(new Dimension(size_n*w,size_n*h));
		JF.pack();
		JF.setVisible(true);
		JF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	void Generate_Card()
	{
		int Length=0;
		cards=new Card[Height][Weight];
		Random_Color_Separate=Generate_random_color(Weight,Height);
		for(int i=0;i<Height;i++)
		{
			for(int j=0;j<Weight;j++)
			{
				cards[i][j]=new Card();
				cards[i][j].SetColor(Random_Color_Separate.elementAt(Length));
				cards[i][j].setBackground(Random_Color_Separate.elementAt(Length));
				cards[i][j].POS=Length;
				cards[i][j].addActionListener(this);
				Length++;
				JL.add(cards[i][j]);
				Cando=0;
			}
		}
		
		timer = new Timer();
		TimerTask task = new TimerTask()
		{

			@Override
			public void run() 
			{
				Cando=1;
				for(int i=0;i<Height;i++)
				{
					for(int j=0;j<Weight;j++)
					{
						
						cards[i][j].setBackground(null);
		
					}
				}
			}
		};
		
	    timer.schedule(task,5000);
	}
	
	Vector<Color> Generate_random_color(int w,int h)
	{
		Vector<Color> GRCS=new Vector();
		//Iterator<Color> ite=Random_Color.iterator();
		int Couples_Num=(w*h)/2;
		//System.out.println("Couples_Num"+Couples_Num);
		for(int i=0;i<Couples_Num;i++)
		{
	
			int r=random.nextInt(7);
			Random_Color_Vector.addElement(colors_sample[r]);
			Random_Color_Vector.addElement(colors_sample[r]);
		}
		
		int Length=0;
		while(Length<w*h)
		{
			int r=random.nextInt(w*h);
			if(ArrayInt[r]!=0)
			{
				GRCS.addElement(Random_Color_Vector.get(r));		
				ArrayInt[r]=0;
				Length++;
			}
		}
		return GRCS;
	   
		
		
		//while(ite.hasNext()){System.out.println(ite.next());}
		
	
	}
	
	void AddPlayers(Player[] p)
	{
		Player_Number=p.length;
		players=new Player[p.length];
		ShowJF=new JFrame("遊戲訊息");
		ShowJB=new JButton[p.length];
		ShowJL_C=new JLabel[p.length];
		ShowJL_Message=new JLabel[p.length];
		ShowJF.setLayout(new GridLayout(p.length,2));
		for(int i=0;i<p.length;i++)
		{
			players[i]=new Player(p[i].GetName());
			ShowJB[i]=new JButton(p[i].GetName());
			ShowJL_C[i]=new JLabel("     "+p[i].Correct);
			ShowJL_C[i].setFont(new Font("",0,30));
			ShowJL_Message[i]=new JLabel("     ");
			ShowJL_Message[i].setFont(new Font("",0,30));
			ShowJL_Message[i].setForeground(Color.RED);
			//ShowJL[i].setText("     "+p[i].Correct);
			ShowJF.add(ShowJB[i]);
			ShowJF.add(ShowJL_C[i]);
			ShowJF.add(ShowJL_Message[i]);
		}
		ShowJF.setPreferredSize(new Dimension(800,p.length*150));
		ShowJF.pack();
		ShowJF.setVisible(true);
		ShowJF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Card c=(Card)e.getSource();
		ShowJB[Round].setForeground(Color.blue);
		ShowJB[Round].setFont(new Font("monospaced",  Font.BOLD,30));
		//System.out.println(Step);
		if(c.Correct==1)
		{
			Cando=1;
			ShowJL_Message[Round].setText("Empty");
			//System.out.println("Empty");
		}
		
		else if(Step==1&&Cando==1)
		{
			Step1_Card=c;
			Step1_Card.setBackground(Step1_Card.Getcolor());
			Step++;
		}
		
		else if(Step==2&&Cando==1)
		{
			Step2_Card=c;
			Step2_Card.setBackground(Step2_Card.Getcolor());
			if(Step2_Card.Getcolor().equals(Step1_Card.Getcolor())&&Step1_Card.POS!=Step2_Card.POS)
			{
//				System.out.println("Right");
				ShowJL_Message[Round].setText("Correct");
				players[Round].SetCorrect(players[Round].GetCorrect()+1);
				ShowPlayer(Round);
				
				
				
				
				
				
				
				Step=1;
				Step1_Card.Correct=1;
				Step2_Card.Correct=1;
				
				timer = new Timer();
				TimerTask task = new TimerTask(){

					@Override
					public void run() {
						Cando=1;
						Step1_Card.Btn_Transparent();
						Step2_Card.Btn_Transparent();	
						ShowJB[Round].setForeground(Color.blue);
						ShowJB[Round].setFont(new Font("monospaced",  Font.BOLD,30));
						ShowJL_Message[(Round-1+Player_Number)%Player_Number].setText("");
					}};
				
			    timer.schedule(task,2000);		
			    
			}
			
			else//!Step2_Card.Getcolor().equals(Step1_Card.Getcolor()))
			{
				//System.out.println("Wrong");
				ShowJL_Message[Round].setText("Wrong");
				ShowPlayer(Round);
				
				Round++;
				if(Round>=Player_Number){Round=0;}
				
				
				
				
				Step=1;
				
				timer = new Timer();
				TimerTask task = new TimerTask(){

					@Override
					public void run() {
						Cando=1;
						Step1_Card.setBackground(null);
						Step2_Card.setBackground(null);	
						ShowJB[Round].setForeground(Color.blue);
						ShowJB[Round].setFont(new Font("monospaced",  Font.BOLD,30));
						ShowJL_Message[(Round-1+Player_Number)%Player_Number].setText("");
					}};
				
			    timer.schedule(task,2000);
			    
			}
			
			Cando=0;
		}
		
		else
		{
			System.out.println("!!!");
		
		}
		
		
	}
	
	
	void ShowPlayer(int Round)
	{		
		ShowJL_C[Round].setText("     "+players[Round].GetCorrect());		
		ShowJB[Round].setForeground(Color.BLACK);
		ShowJB[Round].setFont(null);
		
	}
			
			

			
			
	
}

class Card extends 	JButton
{
	int POS;
    int value=0;
	int Correct=0;
	Color color;
	void SetbgImage(String url)
	{
		try {
			Image img=ImageIO.read(new File(url));
			this.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void SetColor(Color c)
	{this.color=c;}
	void SetValue(int v)
	{this.value=v;}
	
	void Btn_Transparent()
	{
		this.SetValue(0);
		this.setBackground(Color.BLUE);
		this.setOpaque(false);
		this.setBorder(null);
	}
	
	Color Getcolor()
	{return this.color;}

}

class Player
{
	int Correct=0;
	
	
	String Name;
	Player(String n)
	{this.Name=n;}
		
	String GetName()
	{return this.Name;}
	
	void SetCorrect(int c)
	{this.Correct=c;}
	

	
	int GetCorrect()
	{return this.Correct;}
	
	
}

