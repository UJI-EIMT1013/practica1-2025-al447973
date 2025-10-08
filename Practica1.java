package practica1;

import java.util.*;

public class Practica1 {

    //EJERCICIO 1
    public static Set<Integer> multiplos (Iterator<Integer> it) {
        Set<Integer> aux = new HashSet<>();
        Set<Integer> resultado = new HashSet<>();
        while (it.hasNext()){
            int n = it.next();
            if (n !=0){
                for (int x : aux) {
                    if (n % x == 0) {
                        resultado.add(n);
                    } else if (x % n == 0) {
                        resultado.add(x);
                    }
                }
                aux.add(n);
            }
        }
        return null;
    }

    //EJERCICIO2
    public static void separate (Set<Integer> cuadrados, Set<Integer> noCuadrados)  {
        Set<Integer> todos = new HashSet<>();
        todos.addAll(cuadrados);
        todos.addAll(noCuadrados);

        Set<Integer> nuevosCuadrados = new HashSet<>();
        Set<Integer> nuevosNoCuadrados = new HashSet<>();

        for (int n : todos) {
            boolean esCuadrado = false;
            for (int x : todos) {
                if (x * x == n) {
                    esCuadrado = true;
                    break;
                }
            }
            if (esCuadrado) {
                nuevosCuadrados.add(n);
            } else {
                nuevosNoCuadrados.add(n);
            }
        }

        cuadrados.clear();
        cuadrados.addAll(nuevosCuadrados);

        noCuadrados.clear();
        noCuadrados.addAll(nuevosNoCuadrados);
    }

    //EJERCICIO 3
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {
        Collection<Set<T>> resultado = new ArrayList<>();
        Set<T> actual = new HashSet<>();

        while (it.hasNext()) {
            T elemento = it.next();
            if (actual.contains(elemento)) {
                resultado.add(actual);
                actual = new HashSet<>();
            }
            actual.add(elemento);
        }

        if (!actual.isEmpty()) {
            resultado.add(actual);
        }
        return null;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u,ArrayList<Set<T>> col) {
        Collection<Set<T>> resultado = new ArrayList<>();
        
        for (int i = 0; i < col.size(); i++) {
            for (int j = i + 1; j < col.size(); j++) {
                Set<T> a = col.get(i);
                Set<T> b = col.get(j);

                Set<T> union = new HashSet<>(a);
                union.addAll(b);

                if (union.equals(u)) {
                    resultado.add(a);
                    resultado.add(b);
                }
            }
        }
        return null;
    }



}

