import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

class cal extends JFrame implements ActionListener{
    
    JButton[] nb=new JButton[10];
    JButton[] ob=new JButton[8];
    JButton ba,bs,bm,bd,bdec,bclr,bdel,beq;
    JPanel p;
    JTextField textfield;
    JLabel label = new JLabel();
    double n1=0,n2=0,result=0;
    char operator;
    
    cal()
    {
        setTitle("poojitha calculator!");
        getContentPane().setBackground(Color.BLACK);
        setSize(420,550);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //to display numbers
        label.setBounds(50,10,300,20);
        label.setForeground(Color.WHITE);
        add(label);
        
        //operation performed
        textfield=new JTextField();
        textfield.setBounds(50,40,300,50);
        textfield.setEditable(false);
        add(textfield);
        
        //assign operation button
        ba=new JButton("+");
        bs=new JButton("-");
        bm=new JButton("*");
        bd=new JButton("/");
        bdec=new JButton(".");
        bclr=new JButton("C");
        bdel=new JButton("DEL");
        beq=new JButton("=");

        ob[0]=ba;
        ob[1]=bs;
        ob[2]=bm;
        ob[3]=bd;
        ob[4]=bdec;
        ob[5]=beq;
        ob[6]=bclr;
        ob[7]=bdel;

        //operation button for-loop
        for(int i=0;i<8;i++){
            ob[i].addActionListener(this);
            ob[i].setFocusable(false);
            ob[i].setBackground(Color.BLACK);
            ob[i].setForeground(Color.ORANGE);
        }

        //instantiating number buttons
        nb[0]=new JButton("0");
        nb[1]=new JButton("1");
        nb[2]=new JButton("2");
        nb[3]=new JButton("3");
        nb[4]=new JButton("4");
        nb[5]=new JButton("5");
        nb[6]=new JButton("6");
        nb[7]=new JButton("7");
        nb[8]=new JButton("8");
        nb[9]=new JButton("9");
        
       //number button for-loop
       for(int i=0;i<10;i++){
            nb[i].addActionListener(this);
            nb[i].setFocusable(false);
            nb[i].setBackground(Color.BLACK);
            nb[i].setForeground(Color.ORANGE);
        }

       bclr.setBounds(50, 430, 145, 50);
       bdel.setBounds(205, 430, 145, 50);
       
       //panel for numbers & operation
       p= new JPanel();
       p.setBounds(50, 100, 300, 300);
       p.setLayout(new GridLayout(4,4,10,10));
       p.setBackground(Color.BLACK);

       p.add(nb[1]);
       p.add(nb[2]);
       p.add(nb[3]);
       p.add(ba);
       p.add(nb[4]);
       p.add(nb[5]);
       p.add(nb[6]);
       p.add(bs);
       p.add(nb[7]);
       p.add(nb[8]);
       p.add(nb[9]);
       p.add(bm);
       p.add(bdec);
       p.add(nb[0]);
       p.add(beq);
       p.add(bd);
       
       //add all buttons to frame
       add(bdel);
       add(bclr);
       add(p);
       
       setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource()==nb[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==bdec){
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource()==ba){
            String str = textfield.getText();
            n1=Double.parseDouble(textfield.getText());
            textfield.setText("");
            label.setText(str + "+");
            operator='+';
            
        }
        if(e.getSource()==bs){
             String str = textfield.getText();
            n1=Double.parseDouble(textfield.getText());
            textfield.setText("");
            label.setText(str + "-");
            operator='-';
        }
        if(e.getSource()==bm){
            String str = textfield.getText();
            n1=Double.parseDouble(textfield.getText());
            textfield.setText("");
            label.setText(str + "*");
            operator='*';
        }
        if(e.getSource()==bd){
             String str = textfield.getText();
            n1=Double.parseDouble(textfield.getText());
            textfield.setText("");
            label.setText(str + "/");
            operator='/';
        }
        if(e.getSource()==beq){
            
            n2=Double.parseDouble(textfield.getText());
            
            switch(operator){
                case'+':
                    result = n1 + n2;
                    textfield.setText(Double.toString(result));
                    label.setText("");
                    break;
                case'-':
                    result=n1-n2;
                    textfield.setText(Double.toString(result));
                    label.setText("");
                    break;
                case'*':
                    result=n1*n2;
                    textfield.setText(Double.toString(result));
                    label.setText("");
                    break;
                case'/':
                    result=n1/n2;
                    textfield.setText(Double.toString(result));
                    label.setText("");
                    break;
            }
            textfield.setText(String.valueOf(result));
            n1=result;
        }
        if(e.getSource()== bclr){
            textfield.setText("");
        }
        if(e.getSource()==bdel){
            String string=textfield.getText();
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++){
                textfield.setText(textfield.getText()+string.charAt(i));
            }
                
           
        }
    
}
}


class Simplecal  {
    public static void main(String[] args){
        new cal();
    }
}
