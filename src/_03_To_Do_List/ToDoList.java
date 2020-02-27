package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	JButton addTasks;
	JButton viewTasks;
	JButton removeTasks;
	JButton saveList;
	JButton loadList;
	JFrame frame;
	JPanel panel;
	ArrayList<String> arrList;

	public void gui() {
		arrList = new ArrayList<String>();
		frame = new JFrame();
		panel = new JPanel();
		addTasks = new JButton("add tasks");
		viewTasks = new JButton("view tasks");
		removeTasks = new JButton("remove tasks");
		saveList = new JButton("save list");
		loadList = new JButton("load list");

		addTasks.addActionListener(this);
		viewTasks.addActionListener(this);
		removeTasks.addActionListener(this);
		saveList.addActionListener(this);
		loadList.addActionListener(this);

		panel.add(addTasks);
		panel.add(viewTasks);
		panel.add(removeTasks);
		panel.add(saveList);
		panel.add(loadList);

		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.pack();

	}

	public static void main(String[] args) {
		ToDoList run = new ToDoList();
		run.gui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bp = (JButton) e.getSource();
		if (bp == addTasks) {
			String addStr = JOptionPane.showInputDialog("what task would you like to add");
			arrList.add(addStr);
			// System.out.println(arrList);
		}
		if (bp == viewTasks) {
			JOptionPane.showMessageDialog(null, arrList);
		}
		if (bp == removeTasks) {
			String removeArr = JOptionPane.showInputDialog("remove which one?");
			for (int i = 0; i < arrList.size(); i++) {
				if (removeArr.equals(arrList.get(i)))
					;
				arrList.remove(i);
			}
		}
		if (bp == saveList) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/text.txt");
				for (String s : arrList) {
					fw.write(s + "/n");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println(" save list not working");
			}
		}
		if (bp == loadList) {
			String fileName = JOptionPane.showInputDialog("file name?");

			try {
				BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/" + fileName));
				String readLine = br.readLine();
				while (readLine != null) {
					System.out.println(readLine);
					readLine = br.readLine();
				}
				br.close();
			} catch (Exception e3) {
				// TODO: handle exception
				e3.printStackTrace();
				System.out.println("load list not working");
			}
		}
	}
}
