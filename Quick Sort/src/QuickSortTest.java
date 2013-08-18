import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;


public class QuickSortTest {
	private int arr[];
	private int arrM[];
	private int arrI[];
	private int arrT[];
	
	@Before
	public void setUp() throws Exception {
		
		arr = new int[1000];
		arrM = new int[10000000];
		arrI = new int[10000000];
		arrT = new int[10000000];
		
		
		Random r = new Random();
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = r.nextInt(arr.length);
		}
		
		r = new Random();
		
		for(int i = 0; i < arrM.length; i++){
			arrM[i] = r.nextInt(arrM.length);
		}
		
		r = new Random();
		
		for(int i = 0; i < arrM.length; i++){
			arrI[i] = r.nextInt(arrM.length);
		}	
		
		r = new Random();
		
		for(int i = 0; i < arrM.length; i++){
			arrT[i] = r.nextInt(arrM.length);
		}	
		
	}


	@Test
	public void test() {
		
		QuickSort.sort(arr);
		
	}
	
	
	@Test
	public void testMassize(){
		
		QuickSort.sort(arrM);
		
	}
	
	@Test
	public void incredibleSort(){
		
		Arrays.sort(arrI);
		
	}
	
	@Test
	public void threadedQuickSort(){
		
		QuickSortThreaded.sort(arrT);
		
		System.out.println(arrT[1231333]);
		System.out.println(arrT[1231334]);
		System.out.println(arrT[1231335]);

		System.out.println(arrT[1231336]);

		System.out.println(arrT[1231337]);

		System.out.println(arrT[1231338]);

		System.out.println(arrT[1231339]);
		
		
	}
}
