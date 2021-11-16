package ProjektGUI3;

public class Octopus {
  private   Macka macka1;
   private Macka macka2;
    private Macka macka3;
    private  Macka macka4;
    private boolean strategiaon = false;

    public Octopus() {
        this.macka1 = new Macka(4);
        this.macka2 = new Macka(5);
        this.macka3 = new Macka(4);
        this.macka4 = new Macka(3);
    }

    public boolean isStrategiaon() {
        return strategiaon;
    }

    public void strategia1() {
        strategiaon = true;
        macka1.moveTentacle();
        if (macka1.getStage() == 0) {
            strategiaon = false;
        }
        System.out.println("strategia 1");
    }
    public void strategia2()
    {
        macka1.moveTentacle();
        System.out.println("strategia 2");
    }
    public void strategia3()
    {
        macka2.moveTentacle();
        System.out.println("strategia 3");
    }
    public void strategia4()
    {
        System.out.println("strategia 4");
        macka3.moveTentacle();
    }
    public void strategia5()
    {
        System.out.println("strategia 5");
        macka4.moveTentacle();
    }

    public void attack() {
        int bigchance = (int) (Math.random() * 4);
        int smallchance = (int) (Math.random() * 2);
        switch(bigchance) {
            case 0:
                if (macka1.stage == 0) {
                    switch (smallchance) {
                        case 0:
                            strategia1();
                            break;
                        case 1:
                            strategia2();
                    }
                } else if (strategiaon) {
                    strategia1();
                } else {
                    strategia2();
                }

                break;
            case 1:
                strategia3();
                break;
            case 2:
                strategia4();
                break;
            case 3:
                strategia5();
                break;
        }

        }

    public Macka getMacka1() {
        return macka1;
    }

    public Macka getMacka2() {
        return macka2;
    }

    public Macka getMacka3() {
        return macka3;
    }

    public Macka getMacka4() {
        return macka4;
    }
}
