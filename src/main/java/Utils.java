import java.util.*;

import static java.util.Objects.isNull;

public class Utils {
    /**
     * Returns a mutable set containing an arbitrary number of elements.
     *
     * @param <E> the {@code Set}'s element type
     * @param elements the elements to be contained in the set
     * @return an {@code HashSet} containing the specified elements
     *         an empty {@code HashSet} if incoming value null, empty array or all incoming values are null
     */
    @SafeVarargs
    @SuppressWarnings("varargs")
    public static <E> Set<E> setOf(E ...elements) {
        return elements == null || elements.length == 0 || Arrays.stream(elements).allMatch(Objects::isNull)
                ? new HashSet<>()
                : new HashSet<>(Arrays.asList(elements));
    }

    public static <E> E getFirstElementOrNull(Collection<? extends E> elements) {
        return elements == null
                ? null
                : elements.stream().findFirst().orElse(null);
    }

    /**
     * Returns a mutable list containing an arbitrary number of elements.
     *
     * @param <E> the {@code List}'s element type
     * @param elements the elements to be contained in the list
     * @return an {@code ArrayList} containing the specified elements
     *         an empty {@code ArrayList} if incoming value null, empty array or all incoming values are null
     */
    @SafeVarargs
    @SuppressWarnings("varargs")
    public static <E> List<E> listOf(E ...elements) {
        return elements == null || elements.length == 0 || Arrays.stream(elements).allMatch(Objects::isNull)
                ? new ArrayList<>()
                : Arrays.asList(elements);
    }

    @SafeVarargs
    @SuppressWarnings("varargs")
    public static <E> List<E> mutableListOf(E ...elements) {
        List<E> mutableArrayList = new ArrayList<>();
        if (isNull(elements)) {
            mutableArrayList.add(null);
        } else {
            mutableArrayList.addAll(Arrays.asList(elements));
        }
        return mutableArrayList;
    }

    public static boolean notNullOrEmpty(Collection<?> collection) {
        return !isNullOrEmpty(collection);
    }

    public static boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    // Java 11
    public static boolean isNullOrBlank(String str) {
        return str == null || str.isBlank();
    }
    public static boolean notNullOrBlank(String str) {
        return !isNullOrBlank(str);
    }
    public static String getEnvVariableOrDefault(String key, String defaultValue) {
        return System.getenv(key) == null ? defaultValue : System.getenv(key);
    }
    private static String getValueByIndexOrDefault(String[] args, int index, String defaultValue) {
        return index < args.length ? args[index] : defaultValue;
    }
}
