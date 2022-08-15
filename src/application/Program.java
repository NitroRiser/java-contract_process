package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

/**
 * Program
 */
public class Program {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Enter contract data");
        System.out.print("Number of contract: ");
        int number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        sc.nextLine();
        Date date = sdf.parse(sc.nextLine());
        System.out.print("Contract Value: ");
        double contractValue = sc.nextDouble();

        Contract con = new Contract(number, date, contractValue);

        System.out.print("Enter number of installments: ");
        int n = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(con, n);

        System.out.println("Installments: ");
        for(Installment x : con.getList()){
            System.out.println(x);
        }

        


        sc.close();
    }
}