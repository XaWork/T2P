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
public final class ProductRepository_Factory implements Factory<ProductRepository> {
  private final Provider<Woocommerce> woocommerceProvider;

  public ProductRepository_Factory(Provider<Woocommerce> woocommerceProvider) {
    this.woocommerceProvider = woocommerceProvider;
  }

  @Override
  public ProductRepository get() {
    ProductRepository instance = newInstance();
    ProductRepository_MembersInjector.injectWoocommerce(instance, woocommerceProvider.get());
    return instance;
  }

  public static ProductRepository_Factory create(Provider<Woocommerce> woocommerceProvider) {
    return new ProductRepository_Factory(woocommerceProvider);
  }

  public static ProductRepository newInstance() {
    return new ProductRepository();
  }
}