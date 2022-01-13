package com.isador.jspe.core;

import java.io.Serializable;
import java.util.Collection;

/**
 * Матрица потребления ресурсов полезной нагрузкой.
 * Представлена в виде таблицы Нагрузка\Ресурс - Количество:
 *
 * <blockquote>
 *   <table class="striped">
 *     <thead>
 *       <th scope="col" style="text-align:left">Нагрузка\Ресурс</th>
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
public interface ConsumptionMatrix extends Serializable {

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
    double getConsumption(Payload payload, Resource resource);

    /**
     * Получить количество ресурса.
     *
     * @param resource потребляемый ресурс.
     *
     * @return количество потребляемого ресурса, null - если такого ресурса нет в матрице.
     *
     * @throws NullPointerException если потребляемый ресурс == null.
     * @since 2.0.0
     */
    Integer getResourceQuantity(Resource resource);

    /**
     * Возвращает коллекцию ресурсов, на которые замаплена
     * полезная нагрузка.
     *
     * @param payload полезная нагрузка, для которой надо вернуть ресурсы.
     *
     * @return Коллекция ресурсов. Не может быть null.
     *
     * @since 1.0.0
     */
    Collection<Resource> getMappedResources(Payload payload);
}
