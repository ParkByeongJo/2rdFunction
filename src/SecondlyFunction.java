import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SecondlyFunction extends JPanel implements ActionListener {
	JTextField a, b, c;
	double A, B, C;
	
	public SecondlyFunction() {
		//2차 함수의 계수를 입력받는 텍스트 필드 생성
		a=new JTextField("1.0",10);
		b=new JTextField("-5.0",10);
		c=new JTextField("6.0",10);
		this.add(a);
		this.add(b);
		this.add(c);
		JButton button=new JButton("DRAW");
		this.add(button);
		button.addActionListener(this);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		g2.drawLine(0, 200, 400, 200);
		g2.drawLine(0, 200, 400, 200);
		g2.setPaint(Color.red);
		//x좌표가 -20에서 20까지 움직일 때, 2차함수를 화면에 타원으로 그린다.
		for(int i=-20;i<20;i++) {
			int x=i;
			int y=(int) (A*x*x-B*x+C);
			g2.fillOval(200+x-2, 200-(y-2), 4, 4);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//버튼이 눌려지면 2차함수의 계수를 읽는다.
		A=Double.parseDouble(a.getText());
		B=Double.parseDouble(b.getText());
		C=Double.parseDouble(c.getText());
		this.repaint();
	}

	public static void main(String[] args) {
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new SecondlyFunction());
		f.setSize(500, 400);
		f.setVisible(true);
	}

}
