package com.isador.jspe.core;

import java.util.Collection;

/**
 * Матрица потребления ресурсов полезной нагрузкой (матрица накладных расходов).
 * Представлена в виде таблицы Ресурс - Нагрузка - Количество:
 *
 * <blockquote>
 *   <table class="striped">
 *     <thead>
 *       <th scope="col" style="text-align:left">Ресурс\Нагрузка</th>
 *       <th scope="col" style="text-align:left">Отправка Сообщения</th>
 *       <th scope="col" style="text-align:left">Сохранение в БД</th>
 *       <th scope="col" style="text-align:left">Чтение файла</th>
 *     </thead>
 *     <tbody>
 *       <tr>
 *         <th scope="row" style="text-align:center">SQL</th>
 *         <td style="text-align:center">0.0</td>
 *         <td style="text-align:center">20000.0</td>
 *         <td style="text-align:center">0.0</td>
 *       </tr>
 *       <tr>
 *         <th scope="row" style="text-align:center">I/O</th>
 *         <td style="text-align:center">1000.0</td>
 *         <td style="text-align:center">0.0</td>
 *         <td style="text-align:center">20000.0</td>
 *       </tr>
 *       <tr>
 *         <th scope="row" style="text-align:center">Network</th>
 *         <td style="text-align:center">300.000</td>
 *         <td style="text-align:center">0.0</td>
 *         <td style="text-align:center">2.0</td>
 *       </tr>
 *     </tbody>
 *   </table>
 * </blockquote>
 * <p>
 *     @since 1.0.0
 */
public interface ConsumptionMatrix {

    /**
     * Потребление ресурса.
     *
     * @param payload  полезная нагрузка.
     * @param resource потребляемый ресурс.
     *
     * @return Количество потребления ресурса.
     * 0.0 - если нет такого сочетания.
     *
     * @throws NullPointerException Если payload == null. Если resource == null.
     * @since 1.0.0
     */
    Double getConsumption(Payload payload, Resource resource);

    /**
     * Добавить потребление ресурса определенной нагрузкой.
     *
     * @param payload  полезная нагрузка.
     * @param resource потребляемый ресурс.
     * @param value    объём потребления.
     *
     * @throws NullPointerException     если объём потребления == null.
     *                                  Если payload == null.
     *                                  Если resource == null.
     * @throws IllegalArgumentException если объём потреблиеня < 1.
     * @since 1.0.0
     */
    void setConsumption(Payload payload, Resource resource, Double value);

    /**
     * Удалить потребления ресурса.
     *
     * @param payload  полезная нагрузка.
     * @param resource потребляемый ресурс.
     *
     * @throws NullPointerException Если payload == null. Если resource == null.
     * @since 1.0.0
     */
    void remove(Payload payload, Resource resource);

    /**
     * Возвращает коллекцию ресурсов, на которые замаплена
     * полезная нагрузка.
     *
     * @param payload полезная нагрузка, для которой надо вернтуть ресурсы.
     *
     * @return коллекция ресурсов. Не может быть null.
     *
     * @since 1.0.0
     */
    Collection<Resource> getMappedResources(Payload payload);
}
