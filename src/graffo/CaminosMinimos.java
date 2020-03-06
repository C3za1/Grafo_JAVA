/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graffo;

/**
 *
 * @author cesar
 */
public class CaminosMinimos 
{
    public String algoritmoFloyd(long [][] mAdy)
    {
        int vertices= mAdy.length;
    long matrizAdyacencia[][]=mAdy;
    String caminos [][]=new String [vertices] [vertices];
    String caminosAuxiliares[][]=new String [vertices] [vertices];
    String caminoRecorrido="", cadena="", camin2="";
    int i,j,k;
    float t1, t2,t3, t4, min;
    
    for(i=0; i<vertices; i++)
    {
        for(j=0; j<vertices; j++)
        {
            caminos[i][j]="";
            caminosAuxiliares[i][j]="";
        }
    }
    for(k=0; k<vertices; k++)
    {
        for(i=0; i<vertices; i++)
    {
        for(j=0; j<vertices; j++)
    {
        t1=matrizAdyacencia[i][j];
        t2=matrizAdyacencia[i][k];
        t3=matrizAdyacencia[k][j];
        t4=t2+t3;
        
        min=Math.min(t1, t4);
        if(t1!=t4)
        {
            if(min==t4)
            {
                caminoRecorrido="";
                caminosAuxiliares[i][j]=k+"";
                caminos[i][j]=caminosR(i,k,caminosAuxiliares,caminoRecorrido)+(k+1);
            }
        }
        matrizAdyacencia[i][j]=(long) min;
    }
    }
    }
    for(i=0; i<vertices; i++)
    {
        for(j=0; j<vertices; j++)
        {
            cadena=cadena+"["+matrizAdyacencia[i][j]+"]";
        }
        cadena=cadena+"\n";
    }
    
    for(i=0; i<vertices; i++)
    {
        for(j=0; j<vertices; j++)
    {
        if(matrizAdyacencia[i][j]!=1000000000)
        {
            if(i!=j)
            {
               if(caminos[i][j].equals(""))
                {
                    camin2 +="De: ("+(i+1)+" a "+(j+1)+") El camino que puede ir...("+(i+1)+", "+(j+1)+")\n";
                }
                else
               {
 //checar
                camin2 +="De: ("+(i+1)+" a "+(j+1)+") El camino que puede ir...("+(i+1)+", "+caminos[i][j]+", "+(j+1)+")\n";
               }    
            }
        }
    }
    }
  //  return "La matriz de caminos mas cortos entre los diferentes vertices es: \n"+cadena+"\n los diferentes caminos mas cortos entre vertices son:\n"+camin2;
      return "los diferentes caminos mas cortos entre vertices son:\n"+camin2;
    }
    public String caminosR (int i, int k, String[][] caminosAuxiliares, String caminosRecorrido)
    {
        if(caminosAuxiliares[i][k].equals(""))
        {
            return "";
        }
        else
        {
            caminosRecorrido +=caminosR(i, Integer.parseInt(caminosAuxiliares[i][k].toString()), caminosAuxiliares, caminosRecorrido)+(Integer.parseInt(caminosAuxiliares[i][k].toString())+1)+",";
            return  caminosRecorrido;
        }
    }
}
