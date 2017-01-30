package dbconnect;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graph_view extends Frame implements ActionListener,WindowListener{
    
    public Graph_view(){
        addWindowListener(this);
        setTitle("Graph");
        int id, ton;
        String name, year;
        ResultSet rs;
        MySQL mysql = new MySQL();        
        rs = mysql.selectAll();
        DefaultCategoryDataset data = new DefaultCategoryDataset();

        try {
            while(rs.next()){
                id = rs.getInt("id");
                name = rs.getString("name");
                year = rs.getString("year");
                ton = rs.getInt("ton");
                data.addValue(ton, name, year);
				System.out.println("ID:" + id);
				System.out.println("name：" + name);
				System.out.println("year：" + year);
				System.out.println("ton：" + ton);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JFreeChart chart = 
                ChartFactory.createLineChart("Import Volume","Year","Ton",
                data,PlotOrientation.VERTICAL,true,false,false);
              ChartPanel cpanel = new ChartPanel(chart);
              add(cpanel, BorderLayout.CENTER); 
    }
    @Override
    public void windowActivated(WindowEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void windowClosed(WindowEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void windowClosing(WindowEvent arg0) {
        // TODO Auto-generated method stub
        System.exit(0);
    }
    @Override
    public void windowDeactivated(WindowEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void windowDeiconified(WindowEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void windowIconified(WindowEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void windowOpened(WindowEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
            addWindowListener(this);
            setTitle("Graph");
        }
}