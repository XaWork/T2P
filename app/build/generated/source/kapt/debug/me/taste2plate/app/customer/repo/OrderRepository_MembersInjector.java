// Generated by Dagger (https://dagger.dev).
package me.taste2plate.app.customer.repo;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
import me.taste2plate.app.Woocommerce;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class OrderRepository_MembersInjector implements MembersInjector<OrderRepository> {
  private final Provider<Woocommerce> woocommerceProvider;

  public OrderRepository_MembersInjector(Provider<Woocommerce> woocommerceProvider) {
    this.woocommerceProvider = woocommerceProvider;
  }

  public static MembersInjector<OrderRepository> create(Provider<Woocommerce> woocommerceProvider) {
    return new OrderRepository_MembersInjector(woocommerceProvider);
  }

  @Override
  public void injectMembers(OrderRepository instance) {
    injectWoocommerce(instance, woocommerceProvider.get());
  }

  @InjectedFieldSignature("me.taste2plate.app.customer.repo.OrderRepository.woocommerce")
  public static void injectWoocommerce(OrderRepository instance, Woocommerce woocommerce) {
    instance.woocommerce = woocommerce;
  }
}
