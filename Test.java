import java.util.ArrayList;

public class Test
{
    public void test1()
    {

        Club club = new Club();
        ArrayList<Membership> prueba = new ArrayList<Membership>();

        club.join(new Membership("a", 2, 2004));
        club.join(new Membership("b", 1, 2004));
        club.join(new Membership("c", 1, 2004));
        club.join(new Membership("d", 1, 2005));
        System.out.println("The club has " +
            club.numberOfMembers() +
            " members.");
        club.membersList();

        prueba = club.purge(1, 2004);
        for (Membership miembro : prueba)
        {
            System.out.println(miembro.toString());
        }
        System.out.println("The club has " +
            club.numberOfMembers() +
            " members.");
        club.membersList();

    }
}
