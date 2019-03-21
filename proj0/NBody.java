public class NBody{
    public static double readRadius(String dir) {
        In in = new In(dir);

        int N = in.readInt();
        double R = in.readDouble();
        return R;
    }
    public static Body[] readBodies(String dir){
    	Body[] bodyarr = new Body [5];
    	In in = new In(dir);
        int N = in.readInt();
        double R = in.readDouble();
    	for(int i=0;i<5;i++){
    		double xxPos = in.readDouble();
    		double yyPos = in.readDouble();
    		double xxVel = in.readDouble();
    		double yyVel = in.readDouble();
    		double mass = in.readDouble();
    		String img = in.readString();
    		bodyarr[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, img);
    	}
    	return bodyarr;
    }
    public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
    	double dt = Double.parseDouble(args[1]);
    	String filename = args[2];
    	double radius = readRadius(filename);
    	Body[] bodies = readBodies(filename);

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();

        for(double t=0;t<=T;t+=dt){
        	double[] xForces = new double[bodies.length];
        	double[] yForces = new double[bodies.length];

        	for(int i=0; i<bodies.length; i++){
        		xForces[i] = bodies[i].calcForceExertedByX(bodies);
        		yForces[i] = bodies[i].calcForceExertedByY(bodies);
        	}
        	for(int i=0; i<bodies.length; i++){
        		bodies[i].update(dt, xForces[i], yForces[i]);
        	}

        	StdDraw.picture(0, 0, "images/starfield.jpg");

        	for (Body b:bodies){
        		b.draw();
        	}
        	StdDraw.show();
        	StdDraw.pause(10);
        }
    }
}