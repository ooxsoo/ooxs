package Calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextArea;
import javax.swing.JLabel;
/*计算器 失败第一种：设计初期使用正则表达式 从textarea中提取字符串 之后提取数字
   一直报错 提取不到字符串
   失败第二种 ：采用功能键点击 变量加一
   第三种:使用javascript
*/
public class Calculator {
//    private double a;
//    private double b;
//    private String sign;
//    private int count=0;
	private JFrame frame;
	private JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("计算器");
		frame.setBounds(100, 100, 448, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false); 
		textArea = new JTextArea();
		
		textArea.setBounds(43, 22, 345, 23);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.setBounds(43, 78, 93, 23);
		//事件监听器
		btnNewButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
			
				textArea.append("1");
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("2");
		btnNewButton_1.setBounds(165, 78, 93, 23);
		//事件监听器
		btnNewButton_1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				textArea.append("2");
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("3");
		btnNewButton_2.setBounds(295, 78, 93, 23);
		//事件监听器
				btnNewButton_2.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						
						textArea.append("3");
					}
				});
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("4");
		btnNewButton_3.setBounds(43, 137, 93, 23);
		//事件监听器
				btnNewButton_3.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
				
						textArea.append("4");
					}
				});
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("5");
		btnNewButton_4.setBounds(165, 137, 93, 23);
		//事件监听器
		btnNewButton_4.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
		
				textArea.append("5");
			}
		});
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("6");
		btnNewButton_5.setBounds(295, 137, 93, 23);
		//事件监听器
		btnNewButton_5.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
		
				textArea.append("6");
			}
		});
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("7");
		btnNewButton_6.setBounds(43, 210, 93, 23);
		//事件监听器
		btnNewButton_6.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
		
				textArea.append("7");
			}
		});
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("8");
		btnNewButton_7.setBounds(165, 210, 93, 23);
		//事件监听器
		btnNewButton_7.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
		
				textArea.append("8");
			}
		});
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("9");
		btnNewButton_8.setBounds(295, 210, 93, 23);
		//事件监听器
		btnNewButton_8.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
		
				textArea.append("9");
			}
		});
		frame.getContentPane().add(btnNewButton_8);
		
		JButton button = new JButton("0");
		button.setBounds(43, 282, 93, 23);
		//事件监听器
		button.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
		
				textArea.append("0");
			}
		});
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton(".");
		button_1.setFont(new Font("宋体", Font.PLAIN, 16));
		button_1.setBounds(165, 282, 93, 23);
		//事件监听器
		button_1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
		
				textArea.append(".");
			}
		});
		frame.getContentPane().add(button_1);
		
		JButton btnClear = new JButton("clear");
		btnClear.setBounds(301, 282, 93, 23);
		//
		btnClear.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				textArea.setText(null);
			}
		});
		frame.getContentPane().add(btnClear);
		
		JButton button_2 = new JButton("+");
		button_2.setBounds(43, 339, 93, 23);
		//事件监听器
		button_2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
//		        sign="+";
//		        count=count+1;
//				String f=textArea.getText();
//				textArea.append(sign);
//				a=Double.parseDouble(f);
//				if(count==1){
//					textArea.setText(null);
//					String g=textArea.getText();
//				    b=Double.parseDouble(g);
//				}
//				System.out.println(a);
//				System.out.println(b);
//				System.out.println(count);
				textArea.append("+");
			}
		});
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("-");
		button_3.setBounds(165, 339, 93, 23);
		button_3.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
		
				textArea.append("-");
			}
		});
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("=");
		button_4.setBounds(301, 339, 93, 23);
		button_4.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
		
				//textArea.append("=");
			equal();
			
			}
		});
		frame.getContentPane().add(button_4);
		
		JButton btn_cheng = new JButton("*");
		btn_cheng.setBounds(43, 390, 93, 23);
		btn_cheng.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				textArea.append("*");
			}
		});
		frame.getContentPane().add(btn_cheng);
		
		JButton btn_chu = new JButton("/");
		btn_chu.setBounds(165, 390, 93, 23);
		btn_chu.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				textArea.append("/");
			}
		});
		frame.getContentPane().add(btn_chu);
		
		
	}
	//加法
	public void equal() {
//		String result=String.valueOf(a+b);
//		textArea.append(result);
		
//		 String s=textArea.getText();
//		 String regEx ="(\\d)";
//	    // 编译正则表达式
//	    Pattern pattern = Pattern.compile(regEx);
//	    // 忽略大小写的写法
//	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
//	    Matcher matcher = pattern.matcher(s);
//	   System.out.println(matcher.group(0));
//	    
//	    textArea.append(matcher.group(1));
		ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
		String f=textArea.getText();
//		String str = String.valueOf((f));
		 
	
			
		
			try {
				String d = (String) se.eval(f).toString();
				double t=Double.parseDouble(d);
				String m=String.valueOf(t);
				System.out.println(t);
				textArea.setText(m);
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
         
	
//		textArea.setText(h);
  }
}
