    package lab2;
     
    import java.util.Random;
     
    public class Kontrakt implements Psikus
    {
     
            @Override
            public Integer cyfrokrad(Integer liczba)
            {
                   
                    if(Integer.toString(liczba).length()==1 || (Integer.toString(liczba).length()==2 && Integer.toString(liczba).charAt(0)=='-'))
                    {
                            return null;
                    }
                    else
                    {
                            Random generator = new Random();
                            int wielkosc=liczba.toString().length();
                            int pozycja;
                            String licz1;
                            licz1=liczba.toString();
                            StringBuilder sb=new StringBuilder(licz1);
                           
                            if(liczba<0)
                            {
                                    do{
                                            pozycja=generator.nextInt(wielkosc);
                                    }while(pozycja==0);
                                   
                            }
                            else
                            {
                                    pozycja=generator.nextInt(wielkosc);
                            }
                                   
                            sb.deleteCharAt(pozycja);
                            licz1 = sb.toString();
                            liczba=Integer.parseInt(licz1);
                            return liczba;
                    }
            }
     
            @Override
            public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException {
                   
                	if(Integer.toString(liczba).length()==1 || (Integer.toString(liczba).length()==2 && Integer.toString(liczba).charAt(0)=='-'))
                    {
                             throw new NieudanyPsikusException("Jedna cyfra");//dodany konstruktor z message'm
                    }
                    else
                    {
                           
                                    Random generator = new Random();
                                    int wielkosc=liczba.toString().length();
                                    int pozycja1;
                                    int pozycja2;
                                    char znak1;
                                    char znak2;
                                    if(liczba<=0)
                                    {
                                    		pozycja1=0;
                                            do{
                                                    pozycja1=generator.nextInt(wielkosc);
                                            }while(pozycja1==0);
                                            
                                            do{
                                                                   
                                                    pozycja2=generator.nextInt(wielkosc);
                                            }while(pozycja1==pozycja2 || pozycja2==0);
                                                   
                                    }
                                    else {
                                   
                                            pozycja1=generator.nextInt(wielkosc);
                                   
                                            do{
                                                   
                                                    pozycja2=generator.nextInt(wielkosc);
                                            }while(pozycja1==pozycja2);
                                    }
                                   
                                    String licz1;
                                    licz1=liczba.toString();
                                    StringBuilder sb=new StringBuilder(licz1);
                                    znak1=licz1.charAt(pozycja1);
                                    znak2=licz1.charAt(pozycja2);
                                    char[] licz2 = licz1.toCharArray();
                                    licz2[pozycja2]=znak1;
                                    licz2[pozycja1]=znak2;
                                    licz1=String.valueOf(licz2);   
                                    liczba=Integer.parseInt(licz1);
                                    return liczba;
                           
                    }
                   
            }
     
            @Override
            public Integer nieksztaltek(Integer liczba) {
                    Random generator = new Random();
                    int wielkosc=liczba.toString().length();
                    int pozycja1;
                    String licz1;
                    licz1=liczba.toString();// zamiana liczby inta na stringa
                    char[] licz2 = licz1.toCharArray();// zamiana tego stringa na array charowy
                    pozycja1=generator.nextInt(wielkosc);//losujemy pozycje randomowa
                    Boolean passed=false;//kontroler
                    Boolean czyznajdujesie=false;
                    for(int i=0;i<wielkosc;i++)//sprawdzamy czy 3,7 lub 6 wogole znajduja sie w argumencie
                    {
                            if(licz2[i]=='3' || licz2[i]=='7' || licz2[i]=='6'){
                                    czyznajdujesie=true;
                            }
                    }
                    if(czyznajdujesie==true)
                    {
                            do
                            {
                                    if(licz2[pozycja1]=='3' || licz2[pozycja1]=='7' || licz2[pozycja1]=='6'){
                                            passed=true;
                                            if(licz2[pozycja1]=='3') licz2[pozycja1]='8';
                                            else if(licz2[pozycja1]=='7') licz2[pozycja1]='1';
                                            else if(licz2[pozycja1]=='6') licz2[pozycja1]='9';
                                    }
                                    else
                                    {
                                            pozycja1=generator.nextInt(wielkosc);
                                    }
                            }while(passed!=true);
                    }
                            licz1=String.valueOf(licz2);
                            liczba=Integer.parseInt(licz1);
                            return liczba;
                   
            }
          
    }

