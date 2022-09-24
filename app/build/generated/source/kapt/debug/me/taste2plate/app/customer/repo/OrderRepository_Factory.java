// Generated by Dagger (https://dagger.dev).
package me.taste2plate.app.customer.repo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;
import me.taste2plate.app.Woocommerce;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class OrderRepository_Factory implements Factory<OrderRepository> {
  private final Provider<Woocommerce> woocommerceProvider;

  public OrderRepository_Factory(Provider<Woocommerce> woocommerceProvider) {
    this.woocommerceProvider = woocommerceProvider;
  }

  @Override
  public OrderRepository get() {
    OrderRepository instance = newInstance();
    OrderRepository_MembersInjector.injectWoocommerce(instance, woocommerceProvider.get());
    return instance;
  }

  public static OrderRepository_Factory create(Provider<Woocommerce> woocommerceProvider) {
    return new OrderRepository_Factory(woocommerceProvider);
  }

  public static OrderRepository newInstance() {
    return new OrderRepository();
  }
}