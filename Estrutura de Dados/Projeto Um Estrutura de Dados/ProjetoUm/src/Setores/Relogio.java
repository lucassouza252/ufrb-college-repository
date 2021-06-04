package Setores;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class Relogio extends Thread {
    
	private JLabel hr;
    
    public Relogio(JLabel hora) {
        this.hr = hora;
    }
    
    public String pegar() {
    	Date d = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	return sdf.format(d);
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                Date d = new Date();
                StringBuffer data = new StringBuffer();
//              SimpleDateFormat sdfData = new SimpleDateFormat("dd.MM.yyyy");
//              data.append(sdfData.format(d));
//              data.append(" - ");              
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                this.hr.setText(data.toString() + sdf.format(d));
                Thread.sleep(1000);
                this.hr.revalidate();
            }
        } catch (InterruptedException ex) {
        	ex.printStackTrace();
        }
    }
}
