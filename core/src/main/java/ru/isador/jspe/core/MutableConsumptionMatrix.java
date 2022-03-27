package ru.isador.jspe.core;

public interface MutableConsumptionMatrix extends ConsumptionMatrix {

    /**
     * Добавить потребление ресурса определенной нагрузкой.
     *
     * @param payload  полезная нагрузка.
     * @param resource потребляемый ресурс.
     * @param value    объём потребления.
     *
     * @throws NullPointerException     если объём потребления == null.
     *                                  Если полезная нагрузка == null.
     *                                  Если потребляемый ресурс == null.
     * @throws IllegalArgumentException если объём потребления <= 0.
     * @since 2.0.0
     */
    void setConsumption(Payload payload, Resource resource, double value);

    /**
     * Добавить потребление ресурса определенной нагрузкой.
     *
     * @param payload          полезная нагрузка.
     * @param resource         потребляемый ресурс.
     * @param value            объём потребления.
     * @param resourceQuantity количество ресурса.
     *
     * @throws NullPointerException     если объём потребления == null.
     *                                  Если полезная нагрузка == null.
     *                                  Если потребляемый ресурс == null.
     *                                  Если количество ресурса == null.
     * @throws IllegalArgumentException если объём потребления <= 0 или если количество ресурса <= 0.
     * @since 2.0.0
     */
    void setConsumption(Payload payload, Resource resource, double value, int resourceQuantity);

    /**
     * Изменить количество доступного ресурса. Если ресурса нет в матрице - ничего не произойдёт.
     *
     * @param resource потребляемый ресурс.
     * @param quantity количество ресурса.
     *
     * @throws NullPointerException     если потребляемый ресурс == null.
     *                                  Если количество ресурса == null.
     * @throws IllegalArgumentException если количество ресурса <= 0.
     * @since 2.0.0
     */
    void setResourceQuantity(Resource resource, int quantity);

    /**
     * Удалить потребление ресурса.
     *
     * @param payload  полезная нагрузка.
     * @param resource потребляемый ресурс.
     *
     * @throws NullPointerException Если payload == null. Если resource == null.
     * @since 2.0.0
     */
    void remove(Payload payload, Resource resource);
}
