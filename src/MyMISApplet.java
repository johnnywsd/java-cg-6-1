
/*<pre>
   This is a simple example to show how to use the MISApplet
   to make your own pixel-by-pixel framebuffer.

   Two methods you can override from the MISApplet base
   class are initFrame and setPixel.
 */

public class MyMISApplet extends MISApplet {

	//----- THESE TWO METHODS OVERRIDE METHODS IN THE BASE CLASS

	double t = 0;

	public void initFrame(double time) { // INITIALIZE ONE ANIMATION FRAME

		//       REPLACE THIS CODE WITH YOUR OWN TIME-DEPENDENT COMPUTATIONS, IF ANY.

		t = 10 * time;
		

	}

	int rgbBak[];
	double centerX = 200;
	double centerY = 200;
	double  cwidth= 10;
	double space = 30;
	double r=0;
	double R =0;
	double d = 0;
	public void setPixel(int x, int y, int rgb[]) { // SET ONE PIXEL'S COLOR

		//       REPLACE THIS CODE WITH WHATEVER YOU'D LIKE, TO MAKE YOUR OWN COOL IMAGE.

		double fx = ((double)x - W/2) / W;
		double fy = ((double)y - H/2) / H;
		//       for (int j = 0 ; j < 3 ; j++)
		//          rgb[j] = (int)(128 + 128 *
		//             Math.sin(30 * fx + (3 - j) * ImprovedNoise.noise(8 * fx, 8 * fy, t)) *
		//	     Math.sin(30 * fy + (2 + j) * ImprovedNoise.noise(4 * fx, 4 * fy, t)));
		//       for (int j = 0 ; j < 3 ; j++)
		//           rgb[j] = packRGB(255,255,255);
//		double time = Math.abs(Math.sin(t/3));
//		if(Math.abs(y - x*time) < 1 ){
//
//			rgb[0] = 255;
//			rgb[1] = 0;
//			rgb[2] = 0; 
//		}else{
//			rgb[0] = 255;
//			rgb[1] = 255;
//			rgb[2] = 255; 
//		}

		
		rgb[0] = 000;
		rgb[1] = 000;
		rgb[2] = 000;
		
//		randomNum= ImprovedNoise.noise(fx, fy, t);
		for(int i = 0;i*space<W;i++ ){
			r = t%space+i*space;
			R = r + cwidth; 
			
			if(square(r)< square(x-centerX)+square(y-centerY) && square(x-centerX)+square(y-centerY) < square(R*0.96)){
				rgb[0] = 0; //(int) (r/W * 255);
				rgb[1] = 255 - (int) (r/W * 255);
				rgb[2] = (int) (r/W * 255);;
			}
			
		}
		
	}
	
	double square(double a){
		return a*a;
	}

	int getRed(int rgb) { return rgb >> 16 & 255; }
	int getGrn(int rgb) { return rgb >>  8 & 255; }
	int getBlu(int rgb) { return rgb       & 255; }

	int packRGB(int r, int g, int b) {
		return 255 << 24 | r << 16 | g << 8 | b;
	}
}
