package RadixSort;
import java.util.ArrayDeque;
import java.util.Queue;

public class RadixSort {

    public static void radixSort(int[] array) {
        int max = obtenerMaximo(array);

        // Realiza el conteo por cada posicion de digito
        for (int exp = 1; max / exp > 0; exp *= 10) {
            creaContenedores(array, exp);
        }
    }

    public static int obtenerMaximo(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static void creaContenedores(int[] arr, int exp) {
        Queue<Integer>[] contenedores = new ArrayDeque[10];
        for (int i = 0; i < 10; i++) {
            contenedores[i] = new ArrayDeque<>();
        }

        // Distribuye los elementos en los contenedores según el dígito actual
        for (int num : arr) {
            int digit = (num / exp) % 10;
            contenedores[digit].offer(num);
        }

        // Reconstruye el array a partir de los contenedores
        int index = 0;
        for (Queue<Integer> contend : contenedores) {
            while (!contend.isEmpty()) {
                arr[index++] = contend.poll();
            }
        }
    }

    public static void mostrar(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Array original:");
        mostrar(arr);

        radixSort(arr);

        System.out.println("Array ordenado:");
        mostrar(arr);
    }
}

