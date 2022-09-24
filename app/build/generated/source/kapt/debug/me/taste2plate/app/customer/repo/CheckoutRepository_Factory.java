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
public final class CheckoutRepository_Factory implements Factory<CheckoutRepository> {
  private final Provider<Woocommerce> woocommerceProvider;

  public CheckoutRepository_Factory(Provider<Woocommerce> woocommerceProvider) {
    this.woocommerceProvider = woocommerceProvider;
  }

  @Override
  public CheckoutRepository get() {
    CheckoutRepository instance = newInstance();
    CheckoutRepository_MembersInjector.injectWoocommerce(instance, woocommerceProvider.get());
    return instance;
  }

  public static CheckoutRepository_Factory create(Provider<Woocommerce> woocommerceProvider) {
    return new CheckoutRepository_Factory(woocommerceProvider);
  }

  public static CheckoutRepository newInstance() {
    return new CheckoutRepository();
  }
}
