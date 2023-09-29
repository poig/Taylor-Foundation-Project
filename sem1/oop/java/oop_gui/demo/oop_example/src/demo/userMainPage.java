
package CarbonFootprintCalculator;

import javax.swing.*;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userMainPage extends JFrame{
        private static JButton home = new JButton("Home"); 
        private static JButton article = new JButton("Article"); 
        private static JButton quiz = new JButton("Quiz"); 
        private static JButton profile = new JButton("Profile"); 
        private static JButton search = new JButton("Search"); 
        private static JButton options = new JButton("Options"); 
        private static JButton ar = new JButton("Article of the Day"); 
        private static JButton startquiz = new JButton("Start Quiz"); 
        private static JPanel p1 = new JPanel(new GridLayout(1, 0)); 
        private static JPanel p2 = new JPanel(new GridLayout()); 
        private static JPanel p3 = new JPanel(new FlowLayout()); 
        private static JPanel p4 = new JPanel(new GridLayout(2, 0)); 
        private static JLabel l1 = new JLabel();
        private static JLabel l2 = new JLabel();
        static JTabbedPane tp = new JTabbedPane();
        static JFrame art = new JFrame();
        static JFrame qz = new JFrame();
        static JFrame mainpage = new JFrame();
        static JFrame prf = new JFrame();
        static JFrame srch = new JFrame();
        static JFrame optn = new JFrame();
        static JButton r;
        static JFrame x;
        static JButton y;
        static JFrame z;
        static int btnCount = 0;
        
        public static void pages(JFrame z, JButton r, JPanel p){
            z.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            z.setLayout(new BorderLayout());
            z.add(p1, BorderLayout.NORTH);
            z.add(p, BorderLayout.CENTER);
            p1.add(home);
            p1.add(article);
            p1.add(quiz);
            p1.add(profile);
            p1.add(search);
            p1.add(options);
            

            z.setSize(800, 800);
            z.setLocationRelativeTo(null);
            z.setVisible(true);
            
            x=z;
            y=r;
            buttons(x,y);
         }
        
        public static void quiz(){
            quiz.setEnabled(false);
            JPanel qp = new JPanel(new GridLayout()); 
            btnCount+=1;
            if (btnCount<=1){
                l2.setPreferredSize(new Dimension(200, 30));
                l2.setLayout(new BorderLayout());
                l2.add(startquiz);
                qp.add(l2, BorderLayout.SOUTH);
                startquiz.setVisible(true);
            }
            else{
                startquiz.setEnabled(true);
                startquiz.setVisible(true);
            }
            pages(qz,quiz,qp);
         }
        
        public static void article(){
            article.setEnabled(false);
            JPanel ap = new JPanel(new GridLayout()); 
            if (tp.getTabCount()==0){
                JTextArea list = new JTextArea();
                list.setText("Article 1");
                list.setSize(100, 300);
                list.setEditable(true);
                JPanel pp1 = new JPanel();
                pp1.add(list);
                JPanel pp2 = new JPanel();
                JPanel pp3 = new JPanel();
                tp.add("article 1", pp1);
                tp.add("article 2", pp2);
                tp.add("article 3", pp3);
                ap.add(tp, BorderLayout.SOUTH);
            }
            
            pages(art,article, ap);
         }
        
         public static void userMainPage() 
            { 
               home.setEnabled(false);
               JPanel up = new JPanel(new GridLayout()); 
               pages(mainpage,home, up);
            } 
         
        public static void profile(){
            profile.setEnabled(false);
            JPanel pp = new JPanel(new GridLayout()); 
            pages(prf,profile,pp);
         }
        
        public static void search(){
            search.setEnabled(false);
            JPanel sp = new JPanel(new GridLayout()); 
            pages(srch,search,sp);
         }
        
        public static void options(){
            options.setEnabled(false);
            JPanel op = new JPanel(new GridLayout()); 
            pages(optn,options,op);
         }
         
         public static void buttons(JFrame x, JButton y){
             home.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     x.dispose();
                     home.setEnabled(false);
                     y.setEnabled(true);
                     startquiz.setVisible(false);
                     tp.setVisible(false);
                     userMainPage();
                 }
             });
              article.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
                            x.dispose();
                            article.setEnabled(false);
                            y.setEnabled(true);
                            startquiz.setVisible(false);
                            tp.setVisible(true);
                            article();
			}
		});
               quiz.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
                            x.dispose();
                            quiz.setEnabled(false);
                            y.setEnabled(true);
                            tp.setVisible(false);
                            quiz();
			}
		});
               profile.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
                            x.dispose();
                            profile.setEnabled(false);
                            y.setEnabled(true);
                            startquiz.setVisible(false);
                            tp.setVisible(false);
                            profile();
			}
		});
               search.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
                            x.dispose();
                            search.setEnabled(false);
                            y.setEnabled(true);
                            startquiz.setVisible(false);
                            tp.setVisible(false);
                            search();
			}
		});
               options.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
                            x.dispose();
                            options.setEnabled(false);
                            y.setEnabled(true);
                            startquiz.setVisible(false);
                            tp.setVisible(false);
                            options();
			}
		});
         }
         
         
         public static void main(String[] args) 
         { 
             userMainPage(); 
         } 
}
