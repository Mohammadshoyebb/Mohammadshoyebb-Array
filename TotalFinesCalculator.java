public class TotalFinesCalculator {
    public static void main(String[] args) {
        int[] fines = {500, 340, 150, 400, 650, 700};
        int[] truckNumbers = {2345, 2444, 2567, 2588, 2789, 2891};
        int date = 17;
        
        int totalFine = calculateTotalFine(fines, truckNumbers, date);
        System.out.println("Total fine collected on date " + date + " is: " + totalFine);
    }
    
    public static int calculateTotalFine(int[] fines, int[] truckNumbers, int date) {
        boolean isDateOdd = (date % 2 != 0);
        int totalFine = 0;
        
        for (int i = 0; i < truckNumbers.length; i++) {
            boolean isTruckNumberOdd = (truckNumbers[i] % 2 != 0);
            
            // Collect fine based on the date and truck number parity
            if (isDateOdd && !isTruckNumberOdd) {
                totalFine += fines[i];
            } else if (!isDateOdd && isTruckNumberOdd) {
                totalFine += fines[i];
            }
        }
        
        return totalFine;
    }
}

