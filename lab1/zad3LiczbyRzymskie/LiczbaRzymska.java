
public class LiczbaRzymska 
{
	private int licz;
	LiczbaRzymska(int liczba)
	{
		this.licz=liczba;
	}
	public String toString()
	{
		  String liczbapokonwersji=null;
		  int liczba=this.licz;
		  if (liczba < 1 || liczba > 3999){
			  System.out.println("Liczba z poza zakresu");
			  return null;
		  }
		  else
		  {
		    liczbapokonwersji="";
		    while (liczba >= 1000) 
		    {
		        liczbapokonwersji=liczbapokonwersji+ "M";
		        liczba=liczba-1000; 
		    }
		    while (liczba >= 900) 
		    {
		        liczbapokonwersji=liczbapokonwersji+"CM";
		        liczba=liczba-900;
		    }
		    while (liczba >= 500) 
		    {
		        liczbapokonwersji=liczbapokonwersji+"D";
		        liczba=liczba-500;
		    }
		    while (liczba >= 400) 
		    {
		        liczbapokonwersji=liczbapokonwersji+"CD";
		        liczba=liczba-400;
		    }
		    while (liczba >= 100) 
		    {
		        liczbapokonwersji=liczbapokonwersji+"C";
		        liczba=liczba-100;
		    }
		    while (liczba >= 90) 
		    {
		        liczbapokonwersji=liczbapokonwersji+"XC";
		        liczba=liczba-90;
		    }
		    while (liczba >= 50) 
		    {
		        liczbapokonwersji=liczbapokonwersji+"L";
		        liczba=liczba-50;
		    }
		    while (liczba >= 40) 
		    {
		        liczbapokonwersji=liczbapokonwersji+ "XL";
		        liczba=liczba-40;
		    }
		    while (liczba >= 10) 
		    {
		        liczbapokonwersji=liczbapokonwersji+"X";
		        liczba=liczba-10;
		    }
		    while (liczba >= 9) 
		    {
		        liczbapokonwersji=liczbapokonwersji+"IX";
		        liczba=liczba-9;
		    }
		    while (liczba >= 5) 
		    {
		        liczbapokonwersji=liczbapokonwersji+"V";
		        liczba=liczba-5;
		    }
		    while (liczba >= 4) 
		    {
		        liczbapokonwersji=liczbapokonwersji+"IV";
		        liczba=liczba-4;
		    }
		    while (liczba >= 1) 
		    {
		        liczbapokonwersji=liczbapokonwersji+"I";
		        liczba=liczba-1;
		    }    
		    return liczbapokonwersji;
		  }
	}
	
}

