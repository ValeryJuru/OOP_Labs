package Lab11;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Library {
    // EXPLAIN: Maps keyed by id; TreeMap keeps them sorted by id
    private final Map<String, LibraryItem> items = new TreeMap<>();
    private final Map<String, Member> members = new TreeMap<>();
    private final List<Loan> loans = new ArrayList<>();

    public void addItem(LibraryItem item) {
        if (items.containsKey(item.getId())) {
            throw new IllegalArgumentException("Item id already exists: " + item.getId());
        }
        items.put(item.getId(), item);
    }

    public void registerMember(Member member) {
        if (members.containsKey(member.getId())) {
            throw new IllegalArgumentException("Member id already exists: " + member.getId());
        }
        members.put(member.getId(), member);
    }

    public Loan borrow(String memberId, String itemId)
            throws ItemNotAvailableException, MemberLimitExceededException {
        Member member = findMember(memberId);
        LibraryItem item = findItem(itemId);
        LocalDate today = LocalDate.now();
        // EXPLAIN: loanPeriodDays() runs the Book or Dvd version, whichever the object is
        return createLoan(member, item, today, today.plusDays(item.loanPeriodDays()));
    }

    // EXPLAIN: used when saved loans are reloaded, so the original dates are kept
    public void restoreLoan(String memberId, String itemId, LocalDate borrowedOn, LocalDate dueDate)
            throws ItemNotAvailableException, MemberLimitExceededException {
        createLoan(findMember(memberId), findItem(itemId), borrowedOn, dueDate);
    }

    private Loan createLoan(Member member, LibraryItem item, LocalDate borrowedOn, LocalDate dueDate)
            throws ItemNotAvailableException, MemberLimitExceededException {
        if (member.getLoanCount() >= Member.MAX_LOANS) {
            throw new MemberLimitExceededException(
                    member.getName() + " already has " + Member.MAX_LOANS + " loans");
        }
        item.borrow(member);            // throws if on loan; nothing has changed yet
        Loan loan = new Loan(item, member, borrowedOn, dueDate);
        loans.add(loan);
        member.addLoan(loan);
        return loan;
    }

    public void giveBack(String itemId) {
        LibraryItem item = findItem(itemId);
        Loan loan = loans.stream()
                .filter(l -> l.getItem() == item)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(item.getTitle() + " is not on loan"));
        loans.remove(loan);
        loan.getMember().removeLoan(loan);
        item.giveBack();
    }

    public List<Loan> listOverdue() {
        return loans.stream().filter(Loan::isOverdue).toList();
    }

    public List<LibraryItem> searchByTitle(String text) {
        return items.values().stream()
                .filter(i -> i.getTitle().toLowerCase().contains(text.toLowerCase()))
                .sorted(Comparator.comparing(LibraryItem::getTitle))
                .toList();
    }

    // EXPLAIN: copies, so callers cannot change the library's own collections
    public List<LibraryItem> getItems() { return List.copyOf(items.values()); }
    public List<Member> getMembers() { return List.copyOf(members.values()); }
    public List<Loan> getLoans() { return List.copyOf(loans); }

    private Member findMember(String id) {
        Member m = members.get(id);
        if (m == null) throw new IllegalArgumentException("No member with id " + id);
        return m;
    }

    private LibraryItem findItem(String id) {
        LibraryItem i = items.get(id);
        if (i == null) throw new IllegalArgumentException("No item with id " + id);
        return i;
    }
}