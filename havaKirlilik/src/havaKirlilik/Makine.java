package havaKirlilik;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;

public class Makine {

	private final FIS fis;
	private final double dGaz;
	private final double nufus;
	private final double mevsim;
	public Makine(double dGaz,double nufus, double mevsim) throws URISyntaxException{
		this.dGaz=dGaz;
		this.nufus=nufus;
		this.mevsim=mevsim;
		File file =new File(getClass().getResource("HavaKirlilik.fcl").toURI());
		fis=FIS.load(file.getPath(),true);
		fis.setVariable("dGaz",dGaz);
		fis.setVariable("nufus",nufus);
		fis.setVariable("mevsim",mevsim);
		fis.evaluate();
	}
	@Override
	public String toString() {
		return "havaOran:" +Math.round(fis.getVariable("havaOran").getValue());
	}
	public FIS getModel() {
		return fis;
	}
}
