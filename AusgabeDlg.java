import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AusgabeDlg extends JDialog implements ActionListener
{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtArithmetisch;
	private JTextField txtGeometrisch;
	private JTextField txtHarmonisch;

	private double[] zahlen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			double[] zahlen = { 2.0, 5.0, 5.5, 6.0, 6.0 };

			AusgabeDlg dialog = new AusgabeDlg(zahlen);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AusgabeDlg(double[] zahlen)
	{
		this.zahlen = zahlen;
		initGUI();
		setDatenInMaske();
	}

	private void setDatenInMaske()
	{
		// Arithm. Mittelwerte berechnen
		try
		{
			double mw = Statistik.berechneMittelwert(zahlen,
					MittelwertTyp.ARITHMETISCH);
			this.txtArithmetisch.setText(Double.toString(mw));
		}
		catch (MittelwertException e)
		{
			this.txtArithmetisch.setText(e.getMessage());
		}

		// Geom. Mittelwerte berechnen
		try
		{
			double mw = Statistik.berechneMittelwert(zahlen,
					MittelwertTyp.GEOMETRISCH);
			this.txtGeometrisch.setText(Double.toString(mw));
		}
		catch (MittelwertException e)
		{
			this.txtGeometrisch.setText(e.getMessage());
		}

		// Harm. Mittelwerte berechnen
		try
		{
			double mw = Statistik.berechneMittelwert(zahlen,
					MittelwertTyp.HARMONISCH);
			this.txtHarmonisch.setText(Double.toString(mw));
		}
		catch (MittelwertException e)
		{
			this.txtHarmonisch.setText(e.getMessage());
		}

	}

	private void initGUI()
	{
		setTitle("Ausgabedialog");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 202);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblArithmetisch = new JLabel("Arithmetisch");
			GridBagConstraints gbcLblArithmetisch = new GridBagConstraints();
			gbcLblArithmetisch.anchor = GridBagConstraints.EAST;
			gbcLblArithmetisch.insets = new Insets(0, 0, 5, 5);
			gbcLblArithmetisch.gridx = 0;
			gbcLblArithmetisch.gridy = 0;
			contentPanel.add(lblArithmetisch, gbcLblArithmetisch);
		}
		{
			txtArithmetisch = new JTextField();
			txtArithmetisch.setText("Arithmetisch");
			GridBagConstraints gbcTxtArithmetisch = new GridBagConstraints();
			gbcTxtArithmetisch.insets = new Insets(0, 0, 5, 0);
			gbcTxtArithmetisch.fill = GridBagConstraints.HORIZONTAL;
			gbcTxtArithmetisch.gridx = 1;
			gbcTxtArithmetisch.gridy = 0;
			contentPanel.add(txtArithmetisch, gbcTxtArithmetisch);
			txtArithmetisch.setColumns(10);
		}
		{
			JLabel lblGeometrisch = new JLabel("Geometrisch");
			GridBagConstraints gbcLblGeometrisch = new GridBagConstraints();
			gbcLblGeometrisch.anchor = GridBagConstraints.EAST;
			gbcLblGeometrisch.insets = new Insets(0, 0, 5, 5);
			gbcLblGeometrisch.gridx = 0;
			gbcLblGeometrisch.gridy = 1;
			contentPanel.add(lblGeometrisch, gbcLblGeometrisch);
		}
		{
			txtGeometrisch = new JTextField();
			txtGeometrisch.setText("Geometrisch");
			GridBagConstraints gbcTxtGeometrisch = new GridBagConstraints();
			gbcTxtGeometrisch.insets = new Insets(0, 0, 5, 0);
			gbcTxtGeometrisch.fill = GridBagConstraints.HORIZONTAL;
			gbcTxtGeometrisch.gridx = 1;
			gbcTxtGeometrisch.gridy = 1;
			contentPanel.add(txtGeometrisch, gbcTxtGeometrisch);
			txtGeometrisch.setColumns(10);
		}
		{
			JLabel lblHarmonisch = new JLabel("Harmonisch");
			GridBagConstraints gbcLblHarmonisch = new GridBagConstraints();
			gbcLblHarmonisch.anchor = GridBagConstraints.EAST;
			gbcLblHarmonisch.insets = new Insets(0, 0, 0, 5);
			gbcLblHarmonisch.gridx = 0;
			gbcLblHarmonisch.gridy = 2;
			contentPanel.add(lblHarmonisch, gbcLblHarmonisch);
		}
		{
			txtHarmonisch = new JTextField();
			txtHarmonisch.setText("Harmonisch");
			GridBagConstraints gbcTxtHarmonisch = new GridBagConstraints();
			gbcTxtHarmonisch.fill = GridBagConstraints.HORIZONTAL;
			gbcTxtHarmonisch.gridx = 1;
			gbcTxtHarmonisch.gridy = 2;
			contentPanel.add(txtHarmonisch, gbcTxtHarmonisch);
			txtHarmonisch.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

	public void actionPerformed(ActionEvent arg0)
	{
		this.setVisible(false);
	}
}
