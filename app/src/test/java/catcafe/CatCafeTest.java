package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatCafeTest {

    private CatCafe cafe;

    @BeforeEach
    void setup() {
        cafe = new CatCafe();
    }

    @Test
    void test_add_cat_and_count() {
        // given
        cafe.addCat(new FelineOverLord("Miss Chief Sooky", 2));
        cafe.addCat(new FelineOverLord("Gwenapurr Esmeralda", 3));
        cafe.addCat(new FelineOverLord("Morticia", 3));
        cafe.addCat(new FelineOverLord("Fitzby Darnsworth", 5));

        // when
        var catCount = cafe.getCatCount();

        // then
        assertEquals(3, catCount);
    }

    @Test
    void test_get_cat_by_name_found() {
        // given
        FelineOverLord cat = new FelineOverLord("Miss Chief Sooky", 2);
        cafe.addCat(cat);

        // when
        var getCat = cafe.getCatByName("Miss Chief Sooky");

        // then
        assertEquals(cat, getCat);
    }

    @Test
    void test_get_cat_by_name_not_found() {
        // given
        cafe.addCat(new FelineOverLord("Miss Chief Sooky", 2));

        // when
        var getCat = cafe.getCatByName("Unknown");

        // then
        assertNull(getCat);
    }

    @Test
    void test_get_cat_by_name_null_input() {
        // given
        cafe.addCat(new FelineOverLord("Miss Chief Sooky", 2));

        // when
        var getCat = cafe.getCatByName(null);

        // then
        assertNull(getCat);
    }

    @Test
    void test_get_cat_by_weight_valid() {
        // given
        FelineOverLord cat1 = new FelineOverLord("Miss Chief Sooky", 2);
        FelineOverLord cat2 = new FelineOverLord("Fitzby Darnsworth", 5);
        cafe.addCat(cat1);
        cafe.addCat(cat2);

        // when
        var getCat = cafe.getCatByWeight(4, 10);

        // then
        assertEquals(cat2, getCat);
    }

    @Test
    void test_get_cat_by_weight_max_weight_edge_case() {
        // given
        FelineOverLord cat = new FelineOverLord("Fitzby Darnsworth", 5);
        cafe.addCat(cat);

        // when
        var getCat = cafe.getCatByWeight(4, 5);

        // then
        assertNull(getCat);
    }

    @Test
    void test_get_cat_by_weight_min_weight_edge_case() {
        // given
        FelineOverLord cat = new FelineOverLord("Miss Chief Sooky", 2);
        cafe.addCat(cat);

        // when
        var getCat = cafe.getCatByWeight(2, 3);

        // then
        assertEquals(cat, getCat);
    }

    @Test
    void test_get_cat_by_weight_edge_case() {
        // given
        FelineOverLord cat = new FelineOverLord("Miss Chief Sooky", 2);
        cafe.addCat(cat);

        // when
        var getCat = cafe.getCatByWeight(2, 2);

        // then
        assertNull(getCat);
    }

    @Test
    void test_get_cat_by_weight_max_less_than_min() {
        // given
        cafe.addCat(new FelineOverLord("Miss Chief Sooky", 2));

        // when
        var cat = cafe.getCatByWeight(10, 5);

        // then
        assertNull(cat);
    }

    @Test
    void test_get_cat_by_weight_invalid_range() {
        // given
        cafe.addCat(new FelineOverLord("Miss Chief Sooky", 2));

        // when
        var cat = cafe.getCatByWeight(-1, 5);

        // then
        assertNull(cat);
    }
}
