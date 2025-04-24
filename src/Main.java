import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        final int MAX_OPERACIONES = 20;
        String[] resultados = new String[MAX_OPERACIONES];
        int contador = 0;

        while (continuar) {
            try {
                System.out.println("CALCULADORA DE FIGURAS");
                System.out.println("1. Círculo");
                System.out.println("2. Cuadrado");
                System.out.println("3. Triángulo");
                System.out.println("4. Rectángulo");
                System.out.println("5. Pentágono");
                System.out.println("6. Salir");
                System.out.print("Seleccione una figura: ");
                int opcionFigura = scanner.nextInt();

                if (opcionFigura == 6) {
                    continuar = false;
                    continue;
                }

                if (opcionFigura < 1 || opcionFigura > 5) {
                    System.out.println("Opción inválida.");
                    continue;
                }

                System.out.println("\nOperaciones disponibles:");
                System.out.println("1. Calcular Área");
                System.out.println("2. Calcular Perímetro");
                System.out.print("Seleccione una operación: ");
                int opcionOperacion = scanner.nextInt();

                if (opcionOperacion < 1 || opcionOperacion > 2) {
                    System.out.println("Opción inválida.");
                    continue;
                }

                double resultado = 0;
                String operacionRealizada = "";

                switch (opcionFigura) {
                    case 1:
                        System.out.print("Ingrese el radio del círculo: ");
                        double radio = scanner.nextDouble();
                        if (radio <= 0) {
                            System.out.println("El valor debe ser positivo.");
                            continue;
                        }
                        if (opcionOperacion == 1) {
                            resultado = Math.PI * radio * radio;
                            operacionRealizada = String.format("Área de círculo (radio=%.2f): %.2f", radio, resultado);
                        } else {
                            resultado = 2 * Math.PI * radio;
                            operacionRealizada = String.format("Perímetro de círculo (radio=%.2f): %.2f", radio, resultado);
                        }
                        break;

                    case 2:
                        System.out.print("Ingrese el lado del cuadrado: ");
                        double lado = scanner.nextDouble();
                        if (lado <= 0) {
                            System.out.println("El valor debe ser positivo.");
                            continue;
                        }
                        if (opcionOperacion == 1) {
                            resultado = lado * lado;
                            operacionRealizada = String.format("Área de cuadrado (lado=%.2f): %.2f", lado, resultado);
                        } else {
                            resultado = 4 * lado;
                            operacionRealizada = String.format("Perímetro de cuadrado (lado=%.2f): %.2f", lado, resultado);
                        }
                        break;

                    case 3:
                        if (opcionOperacion == 1) {
                            System.out.print("Ingrese la base del triángulo: ");
                            double base = scanner.nextDouble();
                            System.out.print("Ingrese la altura del triángulo: ");
                            double altura = scanner.nextDouble();
                            if (base <= 0 || altura <= 0) {
                                System.out.println("Los valores deben ser positivos.");
                                continue;
                            }
                            resultado = 0.5 * base * altura;
                            operacionRealizada = String.format("Área de triángulo (base=%.2f, altura=%.2f): %.2f", base, altura, resultado);
                        } else {
                            System.out.print("Ingrese el primer lado del triángulo: ");
                            double lado1 = scanner.nextDouble();
                            System.out.print("Ingrese el segundo lado del triángulo: ");
                            double lado2 = scanner.nextDouble();
                            System.out.print("Ingrese el tercer lado del triángulo: ");
                            double lado3 = scanner.nextDouble();
                            if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
                                System.out.println("Los valores deben ser positivos.");
                                continue;
                            }
                            resultado = lado1 + lado2 + lado3;
                            operacionRealizada = String.format("Perímetro de triángulo (lados=%.2f, %.2f, %.2f): %.2f", lado1, lado2, lado3, resultado);
                        }
                        break;

                    case 4:
                        System.out.print("Ingrese la base del rectángulo: ");
                        double baseR = scanner.nextDouble();
                        System.out.print("Ingrese la altura del rectángulo: ");
                        double alturaR = scanner.nextDouble();
                        if (baseR <= 0 || alturaR <= 0) {
                            System.out.println("Los valores deben ser positivos.");
                            continue;
                        }
                        if (opcionOperacion == 1) {
                            resultado = baseR * alturaR;
                            operacionRealizada = String.format("Área de rectángulo (base=%.2f, altura=%.2f): %.2f", baseR, alturaR, resultado);
                        } else {
                            resultado = 2 * (baseR + alturaR);
                            operacionRealizada = String.format("Perímetro de rectángulo (base=%.2f, altura=%.2f): %.2f", baseR, alturaR, resultado);
                        }
                        break;

                    case 5:
                        System.out.print("Ingrese el lado del pentágono: ");
                        double ladoP = scanner.nextDouble();
                        if (ladoP <= 0) {
                            System.out.println("El valor debe ser positivo.");
                            continue;
                        }
                        if (opcionOperacion == 1) {
                            resultado = (5 * ladoP * ladoP) / (4 * Math.tan(Math.PI / 5));
                            operacionRealizada = String.format("Área de pentágono (lado=%.2f): %.2f", ladoP, resultado);
                        } else {
                            resultado = 5 * ladoP;
                            operacionRealizada = String.format("Perímetro de pentágono (lado=%.2f): %.2f", ladoP, resultado);
                        }
                        break;
                }

                if (contador < MAX_OPERACIONES) {
                    resultados[contador] = operacionRealizada;
                    contador++;
                } else {
                    System.out.println("Se ha alcanzado el límite de operaciones almacenadas.");
                }

                System.out.println("Resultado: " + operacionRealizada);

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                scanner.nextLine(); // limpiar buffer
            }
        }

        System.out.println("\n*** Historial de Operaciones ***");
        for (int i = 0; i < contador; i++) {
            System.out.println((i + 1) + ". " + resultados[i]);
        }
        System.out.println("Programa finalizado.");
    }
}

