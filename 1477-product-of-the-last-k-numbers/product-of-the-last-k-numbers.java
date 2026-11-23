class ProductOfNumbers {
    List<Integer> pdt;

    public ProductOfNumbers() {
        pdt = new ArrayList<>();
    }

    public void add(int num) {
        if (num == 0)
            pdt.clear();
        else if (pdt.isEmpty())
            pdt.add(num);
        else
            pdt.add(num * pdt.get(pdt.size() - 1));
    }

    public int getProduct(int k) {
        if (pdt.size() < k)
            return 0;
        if (pdt.size() == k)
            return pdt.get(pdt.size() - 1);
        else
            return pdt.get(pdt.size() - 1) / pdt.get(pdt.size() - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */