package Student_managment_system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StudentTable extends JFrame implements ActionListener{
	private Container c;
	//Jlabel variables
	private JLabel firstnm,lastnm,title,phone,gpa;
	
	//Jtext field variables.
	private JTextField firsttxt,lasttxt,phonetxt,gtxt;
	// Jbuttoon variables.
	private JButton addbtn,upbtn,dlbtn,clrbtn;
	
	//jtable variable;
	private JTable tbl;
	private DefaultTableModel mdl;//creating table without row and coloms.
	private JScrollPane scrl;
	private String[] col = {"First Name","Last Name","Phone Number ","CGPA"};
	private String[] row = new String[4];
	
	
	
	
	
	//constructor of class
	StudentTable(){
		initcomponents();
	}
	//method of initcomponents();
	private void initcomponents() {
		//basic propertise of Jframe
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,700);
		this.setLocationRelativeTo(null);
		this.setTitle("Student Information Management System");
		
		//set the container with jframe;
		c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.cyan);
		
		//custom font class has been created to use it accroding to my choiceable part.like text field, button,
		Font font = new Font("",Font.BOLD,15);
		
		//add title label to Jframe
		title = new JLabel("Student Information");
		title.setFont(font);
		title.setBounds(140,10,250,50);
		c.add(title);
		
		
		//adding first name textfield and button to JFrame
		
		//first name labe
		firstnm = new JLabel("First Name : ");
		firstnm.setBounds(10,80,140,30);
		firstnm.setFont(font);
		c.add(firstnm);
		
		//first name text field;
		firsttxt = new JTextField();
		firsttxt.setBounds(111,80,200,30);
		firsttxt.setFont(font);
		c.add(firsttxt);
		
		// //add btn
		addbtn=  new JButton("ADD");
		addbtn.setBounds(400,80,100,30);
		addbtn.setFont(font);
		c.add(addbtn);
		
		//last name label;
		lastnm = new JLabel("Last Name : ");
		lastnm.setBounds(10,130,150,30);
		lastnm.setFont(font);
		c.add(lastnm);
		//last name text field
		lasttxt = new JTextField();
		lasttxt.setBounds(110,130,200,30);
		lasttxt.setFont(font);
		c.add(lasttxt);
		//phone leabel;
		phone = new JLabel("Phone: ");
		phone.setBounds(10,180,150,30);
		phone.setFont(font);
		c.add(phone);
		//phone text field;
		phonetxt = new JTextField();
		phonetxt.setBounds(110,180,200,30);
		phonetxt.setFont(font);
		c.add(phonetxt);
		//info upgrade button
		upbtn=  new JButton("Update");
		upbtn.setBounds(400,130,100,30);
		upbtn.setFont(font);
		c.add(upbtn);
		//delete button
		dlbtn=  new JButton("Delete");
		dlbtn.setBounds(400,180,100,30);
		dlbtn.setFont(font);
		c.add(dlbtn);
		
		//clear button;
		clrbtn=  new JButton("Clear");
		clrbtn.setBounds(400,230,100,30);
		clrbtn.setFont(font);
		c.add(clrbtn);
		
		////CGPA section
		//cgpa leabel;
		gpa = new JLabel("CGPA: ");
		gpa.setBounds(10,230,150,30);
		gpa.setFont(font);
		c.add(gpa);
		
		//cgpa text field;
		
		gtxt = new JTextField();
		gtxt.setBounds(110,230,200,30);
		gtxt.setFont(font);
		c.add(gtxt);
		
		
		
		
		// table section;
		tbl =  new JTable();
		mdl = new DefaultTableModel();
		mdl.setColumnIdentifiers(col);
		tbl.setModel(mdl);
		
		tbl.setFont(font);
		tbl.setSelectionBackground(Color.green);
		tbl.setBackground(Color.WHITE);
		tbl.setRowHeight(30);
		
		
		//scroll pane
		scrl = new JScrollPane(tbl);
		scrl.setBounds(10,360,740,265);
		c.add(scrl);
		
		// adding add btn to action listener
		addbtn.addActionListener(this);
		clrbtn.addActionListener(this);
		dlbtn.addActionListener(this);
		upbtn.addActionListener(this);
		
		
		
		
		
		
		
		
		
		
		//for update option
		tbl.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				
				int nfr=tbl.getSelectedRow();
				String f = mdl.getValueAt(nfr,0).toString();
				String l = mdl.getValueAt(nfr,1).toString();
				String p = mdl.getValueAt(nfr,2).toString();
				String g = mdl.getValueAt(nfr,3).toString();
				
				firsttxt.setText(f);
				lasttxt.setText(l);
				phonetxt.setText(p);
				gtxt.setText(g);
			}
		});
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==addbtn) {
			row[0]= firsttxt.getText();
			row[1]= lasttxt.getText();
			row[2]= phonetxt.getText();
			row[3]= gtxt.getText();
			mdl.addRow(row);
		}
		
		else if (e.getSource()==clrbtn) {
			
			firsttxt.setText(" ");
			lasttxt.setText(" ");
			phonetxt.setText(" ");
			gtxt.setText(" ");
		   
		}
		
		else if(e.getSource()==dlbtn) {
			
			int numofrow= tbl.getSelectedRow();
			if(numofrow>=0) {
				mdl.removeRow(numofrow);
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Sorry! No more info selected or List is empty.");
				
				
			}
			
		}
		
		else if (e.getSource()==upbtn) {
			int numofrow= tbl.getSelectedRow();
			
			String f = firsttxt.getText();
			String l = lasttxt.getText();
			String p = phonetxt.getText();
			String g = gtxt.getText();
			
			mdl.setValueAt(f, numofrow, 0);
			mdl.setValueAt(l, numofrow, 1);
			mdl.setValueAt(p, numofrow, 2);
			mdl.setValueAt(g, numofrow, 3);
			
			
		}
		
	}
	

	// main method
	public static void main(String[] args) {
		StudentTable frame =new StudentTable();
		frame.setVisible(true);
	}
	
	//ki kore basba.. bachar kono line nyy!!
	
	
	

}
