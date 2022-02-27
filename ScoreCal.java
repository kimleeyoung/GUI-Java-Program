//객체지향언어 FinalExam - 2019261064 김이영
package finalExam;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScoreCal extends JFrame implements ActionListener{
  JPanel jp1 = null;
  
  JLabel lb1 = null;
  JLabel lb2 = null;
  JLabel lb3 = null;
  JLabel lb4 = null;
  JLabel lb5 = null;
  JLabel lb6 = null;
  JLabel lb7 = null;
	 
  JTextField[] tf = null;	   
	 
  JLabel line1 = null;
  JLabel line2 = null;
	 
  JButton bt1 = null;
  JButton bt2 = null;
  JButton bt3 = null;
	 
  public ScoreCal(){
	  setLayout(null);
	  setTitle("성적관리 프로그램");
	  setSize(350, 300);
	  setResizable(false);
	  setLocationRelativeTo(null);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	  String[] labelTitle = {"성적관리", "국어 : ", "물리 : ", "영어 : ", "화학 : ", "수학 : ", "생명 : ", "성적출력", "총점 : ", "평균 : "};   
	  JLabel[] label = new JLabel[10];

	  for(int i=0 ; i<labelTitle.length ; i++){
		  label[i] = new JLabel(labelTitle[i]);
	  }
	    
	  tf = new JTextField[8];
	    
	  for(int i=0 ; i<tf.length ; i++){
		  tf[i] = new JTextField();
		  tf[i].setHorizontalAlignment(JTextField.RIGHT); //텍스트필드값을 오른쪽정렬
		  tf[i].setText("0");
	  }
	    
	  jp1 = new JPanel();
	  jp1.setLayout(null);
	  jp1.setSize(350, 300);
	  jp1.setLocation(0, 0);
	  jp1.setBackground(new Color(130,212,245));
	     
	  int lb_x = 5;
	  int lb_y = 5;
	  int lb_width = 55;
	  int lb_height = 15;
	     
	  int tf_x = 45;
	  int tf_y = 38;
	  int tf_width = 70;
	  int tf_height = 20;
	     
	  label[0].setBounds(lb_x, lb_y, lb_width, lb_height);
	  label[0].setOpaque(true);
	  label[0].setFont(new Font("맑은고딕", Font.BOLD, 12));
	  label[0].setBackground(new Color(52,84,98));
	  label[0].setForeground(Color.WHITE);

	  int label_One = 1;
	  int label_Two = 1;
	  for(int i=1 ; i<7 ; i++){
	    	 
		  if((i%2) != 0){
			  label[i].setBounds(lb_x, lb_y + (34*label_One), lb_width, lb_height);
			  label_One++;
		  }else{
			  label[i].setBounds(lb_x + 120, lb_y + (34*label_Two), lb_width, lb_height);
			  label_Two++;
		  }
	  }
	     
	  jp1.add(label[0]);
	  jp1.add(label[1]);
	  jp1.add(label[3]);
	  jp1.add(label[5]);
	  jp1.add(label[2]);
	  jp1.add(label[4]);
	  jp1.add(label[6]);
	     
	  int Text_One = 0;
	  int Text_Two = 0;
	     
	  for(int i=0 ; i<6 ; i++){
		  if((i%2) != 0){
			  tf[i].setBounds(tf_x + 120, tf_y + (30 *Text_One), tf_width, tf_height);
			  tf[i].setOpaque(true);
			  tf[i].setBackground(new Color(217,242,252));
			  Text_One++;
		  }else{
			  tf[i].setBounds(tf_x, tf_y + (30 *Text_Two), tf_width, tf_height);
			  tf[i].setOpaque(true);
			  tf[i].setBackground(new Color(217,242,252));
			  Text_Two++;
		  }
	  }
	  jp1.add(tf[1]);
	  jp1.add(tf[3]);
	  jp1.add(tf[5]);
	  jp1.add(tf[0]);
	  jp1.add(tf[2]);
	  jp1.add(tf[4]);

	  line1 = new JLabel("----------------------------------------------------------");
	  line1.setBounds(lb_x, lb_y, 300, lb_y+250);
	  jp1.add(line1);

	  label[7].setBounds(lb_x, lb_y + 140, lb_width, lb_height);
	  label[7].setOpaque(true);
	  label[7].setFont(new Font("맑은고딕", Font.BOLD, 12));
	  label[7].setBackground(new Color(52,84,98));
	  label[7].setForeground(Color.WHITE);

	  label[8].setBounds(lb_x, lb_y + 163, lb_width, lb_height);
	  tf[6].setBounds(tf_x, lb_y + 160, tf_width, tf_height);
	  tf[6].setOpaque(true);
	  tf[6].setBackground(new Color(217,242,252));

	  label[9].setBounds(lb_x + 120, lb_y + 163, lb_width, lb_height);
	  tf[7].setBounds(tf_x + 120, lb_y + 160, tf_width, tf_height);
	  tf[7].setOpaque(true);
	  tf[7].setBackground(new Color(217,242,252));

	  jp1.add(label[7]);
	  jp1.add(label[8]);
	  jp1.add(label[9]);
	  jp1.add(tf[6]);
	  jp1.add(tf[7]);
	    
	  line2 = new JLabel("----------------------------------------------------------");
	  line2.setBounds(lb_x, lb_y, 300, lb_y+370);
	  jp1.add(line2);
	      
	  bt1 = new JButton("총점");
	  bt1.addActionListener(this);
	  bt1.setBackground(new Color(255,209,97));
	      
	  bt2 = new JButton("평균");
	  bt2.addActionListener(this);
	  bt2.setBackground(new Color(255,209,97));
	      
	  bt3 = new JButton("리셋");
	  bt3.addActionListener(this);
	  bt3.setBackground(new Color(255,209,97));
	      
	  bt1.setBounds(lb_x - 20 + 20, lb_y + 200, 60, 20);
	  bt2.setBounds(lb_x + 85, lb_y + 200, 60, 20);
	  bt3.setBounds(lb_x + 170, lb_y + 200, 60, 20);
	      
	  jp1.add(bt1);
	  jp1.add(bt2);
	  jp1.add(bt3);
	      
	  add(jp1);  
	  setVisible(true);    
  }
  
  public BigDecimal bSum(){
    BigDecimal bKor = new BigDecimal(tf[0].getText());
    BigDecimal bEng = new BigDecimal(tf[1].getText());
    BigDecimal bMath = new BigDecimal(tf[2].getText());
    BigDecimal bScience = new BigDecimal(tf[3].getText());
    BigDecimal bSociety = new BigDecimal(tf[4].getText());
    BigDecimal bmusic = new BigDecimal(tf[5].getText());
    BigDecimal bTo = bKor.add(bEng).add(bMath).add(bScience).add(bSociety).add(bmusic);
    BigDecimal bTotal = bTo.setScale(2, BigDecimal.ROUND_HALF_UP); 
    return bTotal;
  }
	
  public BigDecimal bDivision(){
    BigDecimal bDiv = bSum().divide(new BigDecimal("6"), 2,BigDecimal.ROUND_UP);
    return bDiv;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == bt1){
      tf[6].setText("");
      tf[6].setText(bSum().toString());
    }

    if(e.getSource() == bt2){
      tf[7].setText("");
      tf[7].setText(bDivision().toString());
    }

    if(e.getSource() == bt3){
      for(int i=0 ; i<tf.length ; i++){
        tf[i].setText("");
      }
    }
  }

  public static void main(String[] args) {
    ScoreCal sc = new ScoreCal();
  }
}