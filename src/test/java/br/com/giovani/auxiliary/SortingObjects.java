package br.com.giovani.auxiliary;

import java.util.Comparator;

import br.com.giovani.objects.TableFile;

public class SortingObjects implements Comparator<TableFile>{
	
    public int compare(TableFile o1, TableFile o2) {
        return o2.getName().compareTo(o1.getName());
    }

}