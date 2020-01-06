import java.io.*;
public class array
{
	public static void insert(int[] array,int data,int pos)
	{
		for(int i=9;i>pos-1;i--)
		{
			array[i+1]=array[i];
		}

		array[pos]=data;

		for(int i=0;i<11;i++)
		{
			System.out.print(array[i]+" ");
		}
		System.out.println("");
	}
	public static void delete(int[] array,int pos)
	{
		for(int i=pos+1;i<11;i++)
		{
			array[i-1]=array[i];
		}
		for(int i=0;i<10;i++)
		{
			System.out.print(array[i]+" ");
		}
		System.out.println("");

	}
	public static void update(int[] array,int data,int pos)
	{
		array[pos-1]=data;
		for(int i=0;i<10;i++)
		{
			System.out.print(array[i]+" ");
		}
		System.out.println("");
	}
	public static void search(int[] array,int data)
	{
		boolean flag = false;
		for(int i=0;i<10;i++)
		{
			if(data==array[i])
			{
				flag = true;
			}
		}
		if(flag==true)
		{
			System.out.println("element found");
		}
		else
		{
			System.out.println("element not found");
		}
	}
	public static void sort(int[] array)
	{
		int temp;
		for(int i=0;i<10;i++)
		{
			for(int j=0; j<10;j++)
			{
				if(array[i]<array[j])
				{
					temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}

		for(int i=0;i<10;i++)
		{
			System.out.print(array[i]+" ");
		}
		System.out.println("");
	}


	public static void twodarray()
	{
		int twod[][] = new int[3][3];

		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				twod[i][j] = 1;
			}
		
		}
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(twod[i][j]+" ");
			}
			System.out.println("");
		} 
	}

	public static void main(String[] args) {
		int array[] = new int[11];

		array[0]=1;
		array[1]=2;
		array[2]=3;
		array[3]=4;
		array[4]=5;
		array[5]=6;
		array[6]=7;
		array[7]=8;
		array[8]=9;
		array[9]=10;
		array[10]=0;

		insert(array,90,5);
		delete(array,5);
		update(array,50,4);
		update(array,80,9);
		search(array,6);
		search(array,6000);
		sort(array);
		twodarray();
	}

}